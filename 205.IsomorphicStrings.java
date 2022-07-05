//s1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int [] m = new int[512];
        for (int i=0;i<n;i++) {
            if (m[s.charAt(i)]!=m[t.charAt(i)+256])
                return false;
            m[s.charAt(i)]=m[t.charAt(i)+256]=i+1;
        }
        return true;
    }
}

// s2
// 20 ms
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> m = new HashMap<>(), o = new HashMap<>();
        int n = s.length();
        for( int i=0;i<n;i++) {
            if (!m.getOrDefault(s.charAt(i),0).equals(o.getOrDefault(t.charAt(i),0))) {
                return false;
            }
            m.put(s.charAt(i),i+1);
            o.put(t.charAt(i),i+1);
        }
        return true;
    }
}
