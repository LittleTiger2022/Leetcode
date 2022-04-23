//  双指针，两头向中间移动，交换元素。
class Solution {
    public void reverseString(char[] s) {
       if (s.length<1) return;
        int right = s.length-1;
        int left = 0;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
