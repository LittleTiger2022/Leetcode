// my naive solution 
// 10 ms
class Solution {
    public int search(int[] nums, int target) {
        int i=0, j=nums.length-1, firstPt = 0, lastPt=nums.length-1, location=0;
    if (nums[0]>nums[nums.length-1]) {
        while (i<j){
            int k = (i+j)/2;
            if (nums[k]>nums[i]) {i = k;}
            else if (nums[k]<nums[i]) {j =k;}
            else {firstPt=k+1; lastPt=k; break;}         
        }
    }
        System.out.println("firstPt=" + firstPt);
         if (target<nums[firstPt] || target> nums[lastPt]) { return -1;} 
         if (target==nums[firstPt] ) {return firstPt;}
         if (target==nums[lastPt] )  {return  lastPt;}
        
     if (nums[0]>nums[nums.length-1]) {
         
         if (target<nums[0]) {location= findLoc(nums,firstPt,nums.length-1,target);}
         else { location= findLoc(nums,0,lastPt,target);}
         
     }
        else {
            location= findLoc(nums,0,nums.length-1,target);
        }
      return location;
        
    }
    private int findLoc(int [] nums,int startPt,int endPt, int target) {
        int left=startPt, right = endPt;
        if (target<nums[left] || target> nums[right]) { return -1;} 
        if (target==nums[left] ) {return left;}
        if (target==nums[right] )  {return  right;}
        while (left<right){
            int mid = (left+right)/2;
            if (nums[left]==nums[mid] && nums[left]!=target) {return -1;}
            if (target < nums[mid]) right=mid;
            else if (target>nums[mid]) left = mid;
            if (target==nums[mid]) return mid;
        }
        return left;
    }
}

// clean up version
// 1ms
class Solution {
    public int search(int[] nums, int target) {
        int i=0, j=nums.length-1, firstPt = 0, lastPt=nums.length-1, location=0;
        // 1) find where the smallest value is in nums
    if (nums[0]>nums[nums.length-1]) {
        while (i<j){
            int k = (i+j)/2;
            if (nums[k]>nums[i]) {i = k;}
            else if (nums[k]<nums[i]) {j =k;}
            else {firstPt=k+1; lastPt=k; break;}         
        }
    }
     // 2) find index of the target value   
     if (nums[0]>nums[nums.length-1]) {
         if (target<nums[0]) {location= findLoc(nums,firstPt,nums.length-1,target);}
         else { location= findLoc(nums,0,lastPt,target);}
     }
        else {
            location= findLoc(nums,0,nums.length-1,target);
        }
      return location;
    }
    
    private int findLoc(int [] nums,int startPt,int endPt, int target) {
        int left=startPt, right = endPt;
        if (target<nums[left] || target> nums[right]) { return -1;} 
        if (target==nums[left] ) {return left;}
        if (target==nums[right] )  {return  right;}
        while (left<right){
            int mid = (left+right)/2;
            if (nums[left]==nums[mid] && nums[left]!=target) {return -1;}
            if (target < nums[mid]) right=mid;
            else if (target>nums[mid]) left = mid;
            if (target==nums[mid]) return mid;
        }
        return left;
    }
}

// simple solution
// 1ms
class Solution {
public int search(int [] A, int target) {
        int lo=0,hi=A.length -1;
        if (hi<0) return -1;
        if (hi==0) {
            if (A[hi]==target)  return hi;
            else return -1;
        }
        while(lo<hi){
            int mid=(lo+hi)/2;
            if (A[mid]==target) return mid;
            if (A[lo]<= A[mid]){
                if (target>=A[lo] && target < A[mid])
                    hi = mid -1;
                else 
                    lo = mid +1;
            } else {
                if (target > A[mid] && target <=A[hi])
                    lo = mid +1;
                else
                    hi = mid -1;
            }
            
    }
    return A[lo] == target ? lo:-1;
}
}
