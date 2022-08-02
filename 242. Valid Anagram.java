// solution 1
// O(N) 9ms, 43%
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        
        int [] count = new int[26];
        
        for (int i=0;i<s.length();i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i=0;i<count.length;i++) {
            if (count[i]!=0)
                return false;
        }
        return true;
    }
}

// solution 2: use hashmap
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }
        
        return true;
    }
}
//solution 3: use hashmap (close to stack)
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s == null || t == null || s.length() != t.length())
            return false;
        if(s.length() == 0)
            return true;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c))
                return false;
            else {
                if(map.get(c) == 0)
                    return false;
                map.put(c, map.get(c) - 1);
            }
        }
        
        return true;

    }
}
// My new solution for Grind75
// 3ms (95%) 43 (54%)
class Solution {
    public boolean isAnagram(String s, String t) {
        
        int sLen = s.length();
        if (sLen!=t.length())
            return false;
        
        int [] alphabetTable = new int [26];
        
        for (int i=0;i<sLen;i++) {
            alphabetTable[s.charAt(i)-'a']++;
            alphabetTable[t.charAt(i)-'a']--;
        }
        boolean res = true;
        for (int i=0;i<26;i++) {
            if (alphabetTable[i]!=0) {
                res=false;
                break;
            }
        }
        return res;
    }
}
