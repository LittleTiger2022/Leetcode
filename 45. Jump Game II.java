// 2ms
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int minJump = 0;
        int cur = 0;
        
while (cur<n-1) {
    int localMax = 1, newcur = cur;
    
    if (nums[cur]>= n-1 -cur) return minJump+1;
        System.out.println("cur = " + cur + " num[cur] = " + nums[cur] + "  n = " + n);

    for (int j=1;  j<=nums[cur]; j++) {
        if( (cur+j<n)   &&( nums[cur+j]+j)>localMax) { 
               localMax=nums[cur+j]  +   j ;
               newcur =Math.min(cur+j, n-1);
        }
    }
     minJump ++;
     cur = newcur;
    System.out.println("cur = " + cur + " Jump =" + minJump);
    }
        return minJump;
    }
}

// 2ms, but simpler based on greedy
class Solution {
    public int jump(int[] nums) {
    int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < nums.length - 1; i++) {
		curFarthest = Math.max(curFarthest, i + nums[i]);
		if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
        System.out.println("i= " + i + " nums[i] = " + nums[i] + "  curEnd = " + curEnd + " jump = " + jumps);
	}
	return jumps;     
    }
}
