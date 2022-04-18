// 9ms, 41Mb
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x==0) return true;
        int [] nums = new int[10];
        int i=0, rem=0,length=0;
        while (x>0)  {
            nums[i] = x%10;
            i++;
            x = x/10;
        }
        length = i-1;
        for (i=0;i<length;i++) {
            if (nums[i] !=nums[length-i]) return false;
        }
        return true;
    }
}

// neat one, the same performance
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x !=0 && x%10==0)) return false;
        
        int rev=0;
        while (x>rev)  {
           rev = rev *10 + x%10;
            x /=10;
        }
        
        return rev==x || rev/10 ==x;
    }
}
