// s1
// T(N) 
// 0 ms 100% 41Mb 46%
class Solution {
    public int countSegments(String s) {
        if (s.length()==0 )
            return 0;
        int point =0, countSpace = 0;
        // clean up empty space at the beginning
        while(point<s.length() && s.charAt(point)==' ') {
            point++;
        } 
        
        // now, rule out whole space string
        if (point<s.length()) {
        countSpace++;
            point++;
        while(point<s.length()) {
            if (s.charAt(point)==' ' & s.charAt(point-1)!=' ') {
               countSpace++;
            }
                point++;
        }
        // if the string array ends with empty space, drop one value
        if (s.charAt(--point)==' ') 
            countSpace--;
        }
        
        return countSpace;
        
    }
}

// better solution
// s2 from LC
// O(N) 100% ; O(1) 42Mb 5%
class Solution {
    public int countSegments(String s) {
         int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;  
    }
}
