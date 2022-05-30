// solution 1: backtrack
// Complexity Time: O(n*2^n) Space: O(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        char [] cs = s.toCharArray();
        backTrack(cs,0, new ArrayList<String>(), ans);
        return ans;
    }
    void backTrack(char [] cs, int j, List<String> can, List<List<String>> ans) {
       if (j== cs.length) {
           ans.add(new ArrayList(can));
           return;
       }
        for (int i=j;i<cs.length;i++) {
            if (!isP(cs,j,i))
                continue;
             System.out.println("new String(cs,j,i-j+1)  " + new String(cs,j,i-j+1));
            can.add(new String(cs,j,i-j+1));
            System.out.println("1) i= " + i + " j = " + j + can);
            backTrack(cs,i+1,can,ans);
             System.out.println("2) i= " + i + " j = " + j + can);
            can.remove(can.size()-1);
             System.out.println("3) i= " + i + " j = " + j + can);
        }
    }
    boolean isP(char [] cs, int l, int r) {
        while (l<r) {
            if (cs[l++]!=cs[r--])
                return false;
        }
        return true;
    }
    
}
//new String(cs,j,i-j+1)  a
1) i= 0 j = 0[a]
new String(cs,j,i-j+1)  a
1) i= 1 j = 1[a, a]
new String(cs,j,i-j+1)  b
1) i= 2 j = 2[a, a, b]
2) i= 2 j = 2[a, a, b]
3) i= 2 j = 2[a, a]
2) i= 1 j = 1[a, a]
3) i= 1 j = 1[a]
2) i= 0 j = 0[a]
3) i= 0 j = 0[]
new String(cs,j,i-j+1)  aa
1) i= 1 j = 0[aa]
new String(cs,j,i-j+1)  b
1) i= 2 j = 2[aa, b]
2) i= 2 j = 2[aa, b]
3) i= 2 j = 2[aa]
2) i= 1 j = 0[aa]
3) i= 1 j = 0[]

// solution 2: backtracjing with Dynamic Programming
// time O(N2^N) space O(N*N)
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result,s,0,new ArrayList<>(), dp);
        return result;
    }
    void dfs (List<List<String>> result, String s, int start, List<String> currentList, boolean [][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start)==s.charAt(end) && (end-start<=2 || dp[start+1][end-1])) {
                dp[start][end]= true;
                currentList.add(s.substring(start,end+1));
                dfs(result,s,end+1,currentList,dp);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
