// 8 ms
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
    private List<String> dfs(String s, List<String> dict, Map<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        
        List<String> ans = new ArrayList<String>();
        
        if (s.length()==0) {
            ans.add("");
            return ans; 
        }
        
        for (String word: dict) {
            if (s.startsWith(word)) {
                List<String> canList = dfs(s.substring(word.length()),dict,mem);
                for (String can:canList)
                    ans.add(word+(can.length()==0? "":" ")+ can);
            }
        }
        mem.put(s,ans);
        return ans;
    }
}
// 1ms
// Simple Backtracking
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       List<String> answer = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        
        backtrack(s, 0, answer,new StringBuilder(), dict);
        return answer;
    }
    
    void backtrack(String s, int idx, List<String> ans, StringBuilder sb, Set<String> dict){
        if(idx == s.length()){
            ans.add(sb.toString());
            return;
        }
        
        
        int currlength = sb.length();
        for(int i=idx+1; i<=s.length();i++){
            String str = s.substring(idx, i);
            if(dict.contains(str)){
                if(sb.length()>0) sb.append(" ");
                sb.append(str);
                backtrack(s, i, ans, sb, dict);
                while(sb.length()>currlength) sb.deleteCharAt(sb.length()-1);
            }
        }    
    }
}
