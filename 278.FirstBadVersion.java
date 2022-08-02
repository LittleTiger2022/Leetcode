//s1
// simple binary search
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1, right = n;
        while (left <right) {
            int mid = left + (right-left)/2;
            if (isBadVersion(mid)) 
            right = mid;
            else
                left = mid +1;
            
        }
        // if (isBadVersion(left)) return left;
            return left;
    }
}
