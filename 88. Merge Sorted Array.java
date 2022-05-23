//
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n -1;
        // merge in reverse order
        int nums1N = m-1, nums2N = n-1;
        while (nums1N>=0 && nums2N>=0) {
            if (nums1[nums1N] > nums2[nums2N]) {
                nums1[last]  = nums1[nums1N];
                nums1N--;
            }
            else {
                nums1[last] = nums2[nums2N];
                nums2N--;
            }
            last--; 
        }
        // fill nums1 with leftover num2 elements
        while(nums2N>=0) {
            nums1[last]  = nums2[nums2N];
            last--;
            nums2N--;
        }
    }
}

// simplfied version
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j= n-1, k = m+n -1;
        
        while (j>=0) 
            if (i>=0 && nums1[i]>nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
    }
}
