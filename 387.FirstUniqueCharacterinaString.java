// s1
// O(n+n) 13 ms, 73.57%; 48 (76%)
class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];
        for (int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
    
    int ans = -1;
    
    for (int i=0;i<s.length();i++) {
        if (freq[s.charAt(i)-'a']==1) 
        {
            ans= i;
            break;
        }
    }
    return ans;
}
}
// more concise version

class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];
        for (int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
       
    for (int i=0;i<s.length();i++) {
        if (freq[s.charAt(i)-'a']==1) 
        return i;
    }
    return -1;
}
}
