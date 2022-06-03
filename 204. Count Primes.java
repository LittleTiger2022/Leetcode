// 216 ms
class Solution {
    public int countPrimes(int n) {
      boolean [] nonPrime = new boolean[n];
        int count = 0;
        for (int i=2;i<n;i++) {
            if (nonPrime[i]==false) {
                count++;
                for (int j=2;i*j<n;j++) {
                    nonPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}

// 584 ms
class Solution {
    public int countPrimes(int n) {
        boolean [] np = new boolean[n];
        int m=0;
        for (int i=2;i<n;++i) {
        if (!np[i])
            ++m;
            for (int j=2;i*j<n;++j) {
                np[i*j] = true;
            }
            }
        return m;
    }
}
// 99ms

class Solution {
    public int countPrimes(int n) {
        boolean [] np = new boolean[n];
        int m=0;
        for (int i=2;i<Math.sqrt(n);i++) {
        if (!np[i]) {
                     
            for (int j=i*i;j<n;j+=i) {
                np[j] = true;
            }
            }
        }
         for(int i = 2; i< np.length; i++){
        if(!np[i]) m++;
         }
        return m;
    }
}
