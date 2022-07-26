// s1
// 2 ms (82%) 42Mb (22%)
class Solution {
    public char findTheDifference(String s, String t) {
        int  n = s.length();
        int [] record = new int [26];
        char res =' ';
        for (int i=0;i<n;i++) {
            record[s.charAt(i)-'a']++;
            record[t.charAt(i)-'a']--;
        }
            record[t.charAt(n)-'a']--;
        
        for (int i=0;i<26;i++) {
            if (record[i]<0)
                res = (char) (i +'a'); 
        }
        return res;
    }
}
