// D&C
class Solution {
    public int longestSubstring(String s, int k) {
        int [] freq = new int[26];
        
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;   
        }
        
        boolean valid=true;
        
        int start =0;
        int maxLen =0;
        for (int end =0;end<s.length();end++) {
            if (freq[s.charAt(end)-'a']>0 && freq[s.charAt(end)-'a']<k) {
                String subString = s.substring(start,end);
                maxLen = Math.max(maxLen,longestSubstring(subString,k));
                start = end+1;
                valid = false;
            }
        }
        
        if (valid) {
            return s.length();
        } else {
            return Math.max(maxLen,longestSubstring(s.substring(start),k));
        }
        
    }
}
