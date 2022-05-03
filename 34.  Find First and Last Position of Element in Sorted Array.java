// 0 ms
// note: in line 13, if I use while (left<right) it will take 1 ms.
//
class Solution {
    public static int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            if (n==0 || nums[0]> target || nums[n-1]<target)  {return new int[] {-1,-1};}
            if (n==1 && nums[0]== target ) { return new int[] {0,0};}
            if (n==1 && nums[0]!= target )   { return new int[] {-1,-1};}
        
            int firstPt=0, lastPt=n-1;
            int left = 0,  right =n-1;

            while (left<=right) {

                int mid = (left+right)/2;
                if (nums[mid]>target) {right = mid-1;}
                if (nums[mid]<target) {left = mid+1;}

                // since it is sorted array, consider three cases:
                if (nums[mid]==target) {
                    left = mid;
                    right = mid;
                    while (left>0) {
                        if (nums[left-1]==target) {left--;}
                        else {break;}
                    }
                    while (right<n-1) {
                        if (nums[right+1]==target) {right++;}
                        else {break;}
                    }
                    firstPt=left;
                    lastPt=right;
                    return new int[] {firstPt,lastPt};
                }
                
                if (nums[left]==target)  {
                    firstPt=left;
                    right = left;
                    while (right<n-1) {
                        if (nums[right+1]==target) {right++;}
                        else {break;}
                    }
                    lastPt=right;
                    return new int[] {firstPt,lastPt};
                }
                if (nums[right]==target) {
                    lastPt=right;
                    left = right;
                    while (left>0) {
                        if (nums[left-1]==target) {left--;}
                        else {break;}
                    }
                    firstPt=left;
                    return new int[] {firstPt,lastPt};
                }
            }
            return new int[] {-1,-1};

        }
}
