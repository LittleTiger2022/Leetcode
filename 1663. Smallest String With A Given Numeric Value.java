// my naive solution
// 13ms 99%, 42.5Mb 88.8%
class Solution {
    public String getSmallestString(int n, int k) {
   //     int [] res = new int [n];
        char [] res = new char [n];
        for (int i=0;i<n;i++) {
            res[i]='a';
        }
        
        int remind = k-n;
       int j = n-1;
        
            while(remind>=25 ) {
            res[j] ='z';
            remind-=25;
            j--;
           }
        if (remind>0)
           res[j] = (char) ('a' +remind);
            
        // convert int array to string
         String str = String.copyValueOf(res);
      //   System.out.println(str);
        return(str);
    }
}
// concise solution
class Solution {
    public String getSmallestString(int n, int k) {
        char [] res = new char [n];
        for (int i=0;i<n;i++) {
            res[i]='a';
        }
        k -=n;     
             while(k>0 ) {
            res[--n] +=Math.min(25,k);
                k -= Math.min(25,k);
           }
       return String.valueOf(res);
    }
}
//
class Solution {
    public String getSmallestString(int n, int k) {
        char [] res = new char [n];
         Arrays.fill(res, 'a');
        int remind = k-n;
        int j = n-1;
             while(remind>=25 ) {
                res[j] ='z';
                remind -= 25;
                j--;
           }
        if(remind>0) res[j] = (char) ('a' +remind);
        
       return String.copyValueOf(res);
    }
}

// Interestingly, not matter how I tried to improve the rest solutions, my first solution is always performance the best.
