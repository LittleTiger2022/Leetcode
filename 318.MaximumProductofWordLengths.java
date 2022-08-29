// s1
class Solution {
    public int maxProduct(String[] words) {
        if (words==null || words.length==0)
            return 0;
        int len = words.length;
        int [] value = new int [len];
        int maxProduct = 0;
        for (int i=0;i<len;i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j=0;j<tmp.length();j++) {
                value[i] |= 1<<(tmp.charAt(j)-'a');
            }
            for (int j=0;j<i;j++) {
             if ((value[i] & value[j])==0 && (words[i].length()*words[j].length()>maxProduct))
                 maxProduct = words[i].length()*words[j].length();
            }
        }
        return maxProduct;
    }
}class Solution {
    public int maxProduct(String[] words) {
        if (words==null || words.length==0)
            return 0;
        int len = words.length;
        int [] value = new int [len];
        int maxProduct = 0;
        for (int i=0;i<len;i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j=0;j<tmp.length();j++) {
                value[i] |= 1<<(tmp.charAt(j)-'a');
            }
            for (int j=0;j<i;j++) {
             if ((value[i] & value[j])==0 && (words[i].length()*words[j].length()>maxProduct))
                 maxProduct = words[i].length()*words[j].length();
            }
        }
        return maxProduct;
    }
}
//
