// 14ms
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int count=0;
        // find length of the shortest string
        int minLength =strs[0].length();
        for (int i=1;i<n;i++) {
            String temp = strs[i];
            minLength = Math.min(minLength,temp.length());
            
        }
        char[] chars = new char[minLength];
        String temp = strs[0];
        for (int i=0;i <minLength;i++) chars[i]=temp.charAt(i);
        boolean isCommon = true;
        String commonPre = "";
        for (int i=0;i <minLength;i++) {
        for (int j=1; j<n;j++) {
            if (strs[j].charAt(i)!=chars[i]) isCommon=false;
        }
            if (isCommon==true) commonPre=commonPre+chars[i];
        }
        return commonPre;
    }
}

// 1ms, leetcode solution
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        String prefix = strs[0];
        for (int i=1; i<strs.length;i++) {
            while (strs[i].indexOf(prefix)!=0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
