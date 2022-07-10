// binary search
// 0-1 ms O(logn)
class Solution {
    public boolean isPerfectSquare(int num) {
        int low =1, high = num;
        
        while (low<=high) {
            long mid = (low+high) >>> 1;
            long prod = mid*mid;
            if (prod==num)
                return true;
            else if (prod<num)
                low= (int) mid+1;
            else
                high = (int) mid-1;
        }
        return false;
    }
}
