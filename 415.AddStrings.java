// s1: my naive solution
// 4ms 61%, 43Mb 60%
class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int maxN = Math.max(n1,n2);
        
        StringBuilder res = new StringBuilder();
        int inc =0;
        for (int i=1;i<=maxN;i++) {
            int temp1=0, temp2=0, newValue =0;
            if (i<=n1)
                temp1 = num1.charAt(n1-i)-'0';
            if (i<=n2)
                temp2 = num2.charAt(n2-i)-'0';
            newValue = temp1+temp2 + inc;
            inc = 0;
            if (newValue>=10)
            {
                inc++;
                newValue-=10;
            }
            res.append(newValue);
        }
        if(inc>0)
            res.append(inc);
        //
        String reversed = new StringBuilder(res).reverse().toString();
        return reversed;
    }
}
