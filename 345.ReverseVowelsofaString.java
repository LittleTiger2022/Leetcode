// s1
// 3ms (98%) 42Mb( 89%)
class Solution {
    public String reverseVowels(String s) {
        char [] res = new char [s.length()];
        int [] vowIndex = new int[s.length()];
        int vowCount = 0;
        for (int i=0;i<s.length();i++) {
            res[i] = s.charAt(i);
            if (res[i]=='a' ||res[i]=='e'|| res[i]=='i'||res[i]=='o'||res[i]=='u' ) 
                vowIndex[vowCount++]=i;
            if (res[i]=='A' ||res[i]=='E'|| res[i]=='I'||res[i]=='O'||res[i]=='U' ) 
                vowIndex[vowCount++]=i;
        }
        
        for( int i=0;i<vowCount/2;i++) {
            char temp = res[vowIndex[i]];
            res[vowIndex[i]] = res[vowIndex[vowCount-1-i]];
            res[vowIndex[vowCount-1-i]] = temp;
        }
       return  String.valueOf(res);
    }
}

//
