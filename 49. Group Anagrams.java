
//  11 ms use Hash Table
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> r = new ArrayList<List<String>>();
        Map<String,List<String>> result = new HashMap<String,List<String>>();
        
        for (String str: strs){
            char [] strC= str.toCharArray();
            Arrays.sort(strC);
            String key = new String(strC);
            List<String> l = result.getOrDefault(key,new ArrayList<String>());
            l.add(str);
            result.put(key,l);
            
        }
        r.addAll(result.values());
        return r;
        
    }
}

// 6 ms do not sort the string, use 26 alphabit to obtain key
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

