// 4ms
// recursive 
class Solution {
    public String countAndSay(int n) {
        if (n==1) return "1";
        return countAndSay(countAndSay(n-1));
    }
    private String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        char [] cs = str.toCharArray();
        
        for (int i=0,j=0;i<cs.length;i=j) {
            char cur = cs[i];
            j = i+1;
            while (j<cs.length && cur==cs[j])
                ++j;
            sb.append(j-i);
            sb.append(cur);
        }
        return sb.toString();
            
    }
}

// solution 2: while loop
// 5ms
class Solution {
    public String countAndSay(int n) {
       //  if (n<=0) return "";
        String res = "1";
        while (n>1) {
            StringBuilder cur = new StringBuilder();
            for (int i=0; i< res.length(); ++i) {
                int count = 1;
                while (i+1< res.length() && res.charAt(i) == res.charAt(i+1)) {
                    count++;
                    i++;
                }
                cur.append(count).append(res.charAt(i));
            }
            res = cur.toString();
            --n;
        }
        return res;
    }
}
