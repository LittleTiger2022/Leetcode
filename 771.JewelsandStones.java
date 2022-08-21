//s1
// 2ms (60%) 42Mb (55%)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int [] smallCase = new int[26];
         int [] capCase = new int[26];
        
        for (int i=0;i<jewels.length();i++) {
            if (jewels.charAt(i)-'a'<26 && jewels.charAt(i)-'a'>=0)
                smallCase[jewels.charAt(i)-'a']++;
            else if (jewels.charAt(i)-'A'<26 && jewels.charAt(i)-'A'>=0)
                capCase[jewels.charAt(i)-'A']++;
        }
        int count =0;
        for (int i=0;i<stones.length();i++) {
            if (stones.charAt(i)-'a'>=0 && stones.charAt(i)-'a'<26 && smallCase[stones.charAt(i)-'a']>0)
                count++;
            if (stones.charAt(i)-'A'>=0 && stones.charAt(i)-'A'<26 && capCase[stones.charAt(i)-'A']>0)
                count++;
        }
        return count;
    }
}
// s2
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
            return stones.replaceAll("[^" + jewels + "]", "").length();
    }
}
// s3:  1ms (98%) 42Mb (27%)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
       int[] cnt = new int[128];
        for (char c : stones.toCharArray())
            cnt[c]++;
        int ans = 0;
        for (char c : jewels.toCharArray())
            ans += cnt[c];
        return ans;    
    }
}
