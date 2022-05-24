class Solution {
    public int numDecodings(String s) {
        int nString = s.length();
  int [] numArray = new int [nString];
        for (int i=0;i<nString;i++) {
            numArray[i] = (int) s.charAt(i) - '0';
        // System.out.println(numArray[i]);
        }
        int numWay =0;
        int [] dp = new int [nString+1];
        dp[0] = 1;
        dp[1] = numArray[0]==0 ? 0:1;
        for (int i=2;i<=nString;i++) {
          //  System.out.println("num[i] = " + numArray[i] + "  i = " + i + " nString = "+ nString);
            if (numArray[i-1]!=0 )
                dp[i] += dp[i-1];
            if (numArray[i-2]==1 || (numArray[i-2]==2 && numArray[i-1]<=6))
                dp[i] += dp[i-2];
        }
        System.out.println(Arrays.toString(dp));

     return dp[nString];
    }
    
}
// simplified version
class Solution {
    public int numDecodings(String s) {
        int nString = s.length();
        int [] dp = new int [nString+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0:1;
        for (int i=2;i<=nString;i++) {
            if (s.charAt(i-1)!='0' )
                dp[i] += dp[i-1];
            if (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' &&s.charAt(i-1)<='6'))
                dp[i] += dp[i-2];
        }
     return dp[nString];
    }
    
}
// do not use int array, only use 3 int variables
// 1 ms
class Solution {
    public int numDecodings(String s) {
        int dpNow = 0;
        int  dpPP = 1;
        int dpPast = s.charAt(0)=='0' ? 0:1;
        
        for (int i=2;i<=s.length();i++) {
            if (s.charAt(i-1)!='0' )
                dpNow += dpPast;
            if (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' &&s.charAt(i-1)<='6'))
                dpNow += dpPP;
        // update
            dpPP = dpPast;
            dpPast = dpNow;
            dpNow=0;
        }
     return dpPast;
    }
    
}
}
