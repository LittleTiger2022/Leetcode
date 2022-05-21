//
class Solution {
    public String minWindow(String s, String t) {
        
        int nS = s.length();
        int nT = t.length();
        if (nS<nT || nS==0 || nT==0 ) return "";
        // dict to count unique char in t
        Map<Character,Integer> dictT = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            int count = dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),count+1);
            
        }
    //   System.out.println(Arrays.asList(dictT)); // method 1

        int i=0,j=0,count = dictT.size();
        int left =0, right = nS-1, min = nS;
        boolean found = false;
        
        while (j<nS) {
            char endChar = s.charAt(j++);
        //    System.out.println("min=" + min + " i = " + i + " j = " + j + " endChar = " + endChar + " left = " + left + " right = " + right + "Count = " + count);

            if (dictT.containsKey(endChar)) {
                dictT.put(endChar,dictT.get(endChar)-1);
                if (dictT.get(endChar)==0) count -=1;
            }
            
            if (count>0) continue;
            while (count==0) {
                char starChar = s.charAt(i++);
                if(dictT.containsKey(starChar)) {
                    dictT.put(starChar,dictT.get(starChar)+1);
                    if (dictT.get(starChar)>0) count ++;
                }
            }
        
        if ((j-i)<min) {
            left = i;
            right = j;
            min = j-i;
            found = true;
        }
       //  System.out.println("min=" + min + " i = " + i + " j = " + j + " endChar = " + endChar + " left = " + left + " right = " + right + "Count = " + count);    
    }
        return !found? "":s.substring(left-1,right);
    }
}
