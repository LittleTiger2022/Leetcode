//s1: my naive solution
// 3 ms 73%  41Mb (28%)
// O(1) for both time & space
class Solution {
    public int arrangeCoins(int n) {
        double temp = Math.floor(Math.sqrt(n+1.0/8)*Math.sqrt(2) -0.5);
        // int m1 =(int) (temp - 0.5);
        // int m2 = (int) (temp - 1.5);
        int res = (int) Math.round(temp);
        return res;        
    }
}
// Match with LC solution 2: improved simpler solution
// 1 ms (100%) 41.3Mb (60%)
class Solution {
    public int arrangeCoins(int n) {
        //double temp = Math.floor(Math.sqrt(n+0.125)*Math.sqrt(2) -0.5);
        //int res = (int) Math.round(temp);
        //return res;     
        return (int) (Math.sqrt(n+0.125)*Math.sqrt(2) -0.5);
    }
}
// simpler solution
class Solution {
    public int arrangeCoins(int n) {     
        return (int) (Math.sqrt(n+0.125)*1.4142135623731 -0.5);
    }
}
// s2
// binary search
// O(logN) in time, O(1) in space
// 3 ms (73%) 41.6Mb (35%)
class Solution {
  public int arrangeCoins(int n) {
    long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;

      if (curr == n) return (int)k;

      if (n < curr) {
        right = k - 1;
      } else {
        left = k + 1;
      }
    }
    return (int)right;
  }
}

