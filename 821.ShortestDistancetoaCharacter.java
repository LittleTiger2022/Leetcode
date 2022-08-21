// s1: O(n) both ends for min
class Solution {
    public int[] shortestToChar(String s, char c) {
       
        int len = s.length();
        int[] ans = new int[len];
        ans[0] = s.charAt(0) == c ? 0 : 10001;
        for (int i = 1; i < len; i++) 
            ans[i] = s.charAt(i) == c ? 0 : ans[i-1] + 1;
        for (int i = len - 2; i >= 0; i--)
            ans[i] = Math.min(ans[i], ans[i+1] + 1);  
        return ans;
    }
}
//

