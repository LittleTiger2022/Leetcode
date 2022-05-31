// even though it should be easy, I failed 8 times before passing
// 2ms
class Solution {
    public int removeDuplicates(int[] nums) {
       int   n = nums.length, totalSnowBall =0;
       int  snowball=0, i=2;
        if (n<2) return n;
        int left=2,right=n;
        while (left<right) {

            if (nums[left]==nums[left-2] && nums[left]==nums[left-1] && nums[left]!=-99999) {
               snowball++;
                left++;
            } else if (snowball>0) {
                for (int j=left;j<right;j++) {
                int t = nums[j];
                nums[j] =-99999;
                nums[j-snowball] = t;
                }
                left = left-snowball;
                right = right - snowball;
                totalSnowBall = totalSnowBall + snowball;
                snowball=0;
            }
            else { left++;}
           
        //  System.out.println(Arrays.toString(nums)) ;
       //  System.out.println(" n = " + n + " totalSnallBall = " + totalSnowBall + " snowball = " + snowball + " left = " + left + " right = " + right) ;

        }
   // System.out.println(" stage 2 n = " + n + " snowball = " + snowball) ;

         // consider cases for three numbers
            if (snowball>0) {
                  for (int j=left;j<right;j++) {
                int t = nums[j];
                nums[j] =0;
                nums[j-snowball] = t;
                }
                totalSnowBall = totalSnowBall + snowball;
                snowball=0;
            }
     // System.out.println(" Final n = " + n + " totalSnallBall = " + totalSnowBall) ;
     //     System.out.println(Arrays.toString(nums)) ;

         return n-totalSnowBall;   
    }
}
// cleaned version, still needs 2 ms 14%
class Solution {
    public int removeDuplicates(int[] nums) {
       int   n = nums.length;
       int  snowball=0;
        if (n<2) return n;
        int left=2,right=n;
        while (left<right) {
            if (nums[left]==nums[left-2] && nums[left]==nums[left-1] && nums[left]!=-99999) {
               snowball++;
                left++;
            } else if (snowball>0) {
                for (int j=left;j<right;j++) {
                int t = nums[j];
                nums[j] =-99999;
                nums[j-snowball] = t;
                }
                left = left-snowball;
                right = right - snowball;
                snowball=0;
            }
            else { left++;}
        }
         // consider cases for three numbers at the end
            if (snowball>0) {
                  for (int j=left;j<right;j++) {
                int t = nums[j];
                nums[j] =0;
                nums[j-snowball] = t;
                }
                right = right - snowball;
                snowball=0;
            }
         return right;   
    }
}
// it turns out the solution is very simple
// 1ms
class Solution {
    public int removeDuplicates(int[] nums) {
    int i=0;
        for (int n:nums) {
            if (i<2 || n>nums[i-2])
                nums[i++] = n;
        }
                    return i;

    }
}
