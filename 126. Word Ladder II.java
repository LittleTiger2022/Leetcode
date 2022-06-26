// s1:
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> start = new HashSet<>();
        Set<String>end = new HashSet<>();
        Set<String> dict = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        dict.addAll(wordList);
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        if (!dict.contains(endWord))
            return res;
        buildMap(start,end,false,dict,map);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        genPath(beginWord,endWord,res,map,path);
        return res;
    }
    
    private void genPath(String start, String end, List<List<String>> ans, HashMap<String, List<String>> map, List<String> temp) {
        if(start.equals(end)) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(!map.containsKey(start))
            return;
        for (String s: map.get(start)) {
            temp.add(s);
            genPath(s,end,ans,map,temp);
            temp.remove(temp.size()-1);
        }
    }
    
    private void buildMap(Set<String> start, Set<String> end, boolean reverse, Set<String> dict, HashMap<String, List<String>> map) {
        if (start.size()==0)
            return;
        if (start.size()> end.size()) {
            buildMap(end,start,!reverse,dict,map);
            return;
        }
        
        dict.removeAll(start);
        boolean finished = false;
        HashSet<String> next = new HashSet<>();
        for (String word: start) {
            char [] arr = word.toCharArray();
            for (int i=0;i<arr.length;i++) {
                char old = arr[i];
                for (char c='a';c<='z';c++) {
                    if (c==old)
                        continue;
                arr[i] = c;
                String newString = new String(arr);
                if (dict.contains(newString)) {
                    if (end.contains(newString))
                        finished = true;
                    else
                        next.add(newString);
                    String parent = reverse ? newString: word;
                    String child = reverse ? word: newString;
                    List<String> neighbor = map.getOrDefault(parent, new ArrayList<String>());
                    neighbor.add(child);
                    map.put(parent,neighbor);
                }
            }
            arr[i] = old;
        }
    }
    if(!finished)
        buildMap(next,end,reverse,dict,map);
}
}
