// 7ms. moving window and use dict to map for permutation 
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1= s1.length();
        int n2= s2.length();
        if (n1>n2 | n2==0) return false;
        
        if (n1==0) return true;
        
        int [] array1 = new int[26];
        int [] array2 = new int[26];
        
        for (int i=0;i<n1;i++) {
            array1[s1.charAt(i)-'a']++;
            array2[s2.charAt(i)-'a']++;
        }
        
        for (int i=n1;i<n2;i++) {
            if (Arrays.equals(array1,array2)) return true;
            
            array2[s2.charAt(i-n1)-'a']--;
            array2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(array1,array2)) return true;
        else return false;
    }
}
