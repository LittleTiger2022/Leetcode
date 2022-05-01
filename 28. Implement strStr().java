// brute force approach
// 1ms
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()<1 || haystack.length()<1 ) return 0;
        if ( haystack.length()< needle.length()) return -1;
        int index = -1;
        for (int i =0; i< haystack.length(); i++) {
            if ((haystack.charAt(i)==needle.charAt(0)) && (index<0)) {
                index = i;
                if (needle.length()==1) {
                    return index; }
                else {
                for (int j=1;j<needle.length();j++) {
                    if (((i+needle.length())>haystack.length()) || haystack.charAt(i+j)!=needle.charAt(j)) {
                        index = -1; 
                        break;}
                    // System.out.println(index);   
                }
                }
              
            }
        }
        return index;
    }
}

// keep needle as a hashset, and scan haystack for equal length os substring for comparison.
// 2 ms
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack==null || needle == null) return -1;
        int m = haystack.length();
        int n = needle.length();
        
        Set<String> ns = new HashSet<String>() {
            {  add(needle);
            }
        };
        
        for (int i=0;i<m-n+1;i++) {
            String cur = haystack.substring(i,i+n);
            if(ns.contains(cur)) return i;
        }
        return -1;
    }
}

// improved version to v1 from referring to v2 (i loop stops at m-n+1)
// 0ms 

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()<1 || haystack.length()<1 ) return 0;
        if ( haystack.length()< needle.length()) return -1;
        int index = -1;
        for (int i =0; i< haystack.length()-needle.length()+1; i++) {
            if ((haystack.charAt(i)==needle.charAt(0)) && (index<0)) {
                index = i;
                if (needle.length()==1) {
                    return index; }
                else {
                for (int j=1;j<needle.length();j++) {
                    if (haystack.charAt(i+j)!=needle.charAt(j)) {
                        index = -1; 
                        break;}
                    // System.out.println(index);   
                }
                }
              
            }
        }
        return index;
    }
}
