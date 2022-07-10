// s1 use HashMap
// 35 ms (20%), 51Mb (34%)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    boolean res = true;    
        for (int i = 0;i<magazine.length();i++) { 
             Integer count = map.get(magazine.charAt(i));
            map.put(magazine.charAt(i),(count==null)?1:count+1);
            }
       // System.out.println(map);
        
        for (int i = 0;i<ransomNote.length();i++) {
            char temp = ransomNote.charAt(i);
            if (map.containsKey(temp)) {
                if (map.get(temp)>1)
                    map.put(temp,map.get(temp)-1);
                else 
                    map.remove(temp);
            } else {
                res = false;
                break;
            }
        }
        return res;
        
    }
}

// use frequent table for alphabet
// 4ms 81% 46 Mb 62%
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] freq = new int[26];
        int cnt = 0;
        for (char c: ransomNote.toCharArray()) {
            ++freq[c-'a'];
            ++cnt;
        }
        
        for (char c: magazine.toCharArray()) {
            if (freq[c-'a']>0) {
                --freq[c-'a'];
                --cnt;
                if (cnt ==0)
                    return true;
            }
        }
        return cnt==0;
    }
}
