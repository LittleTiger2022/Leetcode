 //binary search
// 2ms 
class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1) return x;
        
        int l=1,r=x,mid;

        while (l<=r) {
            mid = (l+r)/2;
            if (mid<=x/mid && (mid+1)> x/(mid+1))
                return mid;
            if (mid <x/mid)
                l = mid +1;
            else 
                r = mid-1;
        }
        return -1;
    }
}

// slightly simplified
class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1) return x;
        
        int l=1,r=x,mid;

        while (l<=r) {
            mid = (l+r)/2;
            double leftOver = (double) x/mid;
            double extra = mid +2+ (double) 1/mid;
             // System.out.println("mid = " + mid + "leftOver = " + leftOver + "extra = " + extra);
            if (mid<=leftOver && leftOver < extra)
                return mid;
            
            if (mid < leftOver)
                l = mid +1;
            else 
                r = mid-1;
        }
        return -1;
    }
}

