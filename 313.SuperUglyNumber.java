// s1
// 30 ms (58%) 42Mb (85%)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
       int [] ugly = new int[n];
        ugly[0] = 1;
        int [] pointer = new int [primes.length];
        for (int i=1;i<n;i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j=0;j<primes.length;j++) {
                long product = ugly[pointer[j]]*primes[j];
                if (product <min & product>0) {
                    min = (int) product;
                    minIndex = j;
                } else if (product==min) {
                    pointer[j]++;
                } 
            }
        ugly[i] = min;
        pointer[minIndex]++;
        
    }
    return ugly[n-1];
}
}
//
