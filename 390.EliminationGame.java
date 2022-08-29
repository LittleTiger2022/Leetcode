//s1
class Solution {
    public int lastRemaining(int n) {
      boolean left=true;
        int step =1, head =1;
        while (n>1) {
            if (left || n%2==1)
                head = head + step;
            n/=2;
            step*=2;
            left = !left;
        }
        return head;
    }
}
// recursion
// 3 ms 99.8% 41Mb 94.8%
class Solution {
    public int lastRemaining(int n) {
        if (n==1)
            return 1;
        else
            return 2*(n/2+1-lastRemaining(n/2));
    }
}
