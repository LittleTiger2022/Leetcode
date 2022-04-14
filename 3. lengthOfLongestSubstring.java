// 3ms, 42.4mb 
// use HashSet
class Solution {
    public int lengthOfLongestSubstring(String s) {
     char[] sc = s.toCharArray();
     Set <Character> cs  = new HashSet<>();
        int j=0,maxLen =0;
        for (int i =0; i<sc.length; i++){
            if (!cs.add(sc[i])) {
                maxLen = Math.max(i-j,maxLen);
                while (sc[j++] !=sc[i])
                    cs.remove(sc[j-1]);
            }
        }
            return Math.max(sc.length-j, maxLen);
    }
}
// 3ms, 42.6mb
// two points, moving window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] map = new int[256];
        int start=0, result=0;
        for (int i=0; i<s.length(); i++) {
            map[s.charAt(i)] ++;
            while (map[s.charAt(i)]>1) {
                map[s.charAt(start)]--;
                start++;
            }
            result = Math.max(result,i-start+1);
        }
        return result;
}
}
