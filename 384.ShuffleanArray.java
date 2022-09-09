//s1
// 146 ms 67Mb
class Solution {
    private int [] nums;
    private Random random;
    
    public Solution(int[] nums) {
    this.nums = nums;
    random = new Random();    
    }
    
    public int[] reset() {
    return nums;    
    }
    
    public int[] shuffle() {
     if (nums ==null)
         return null;
     int [] a = nums.clone();
     for (int j=1;j<a.length;j++) {
         int i = random.nextInt(j+1);
         swap(a,i,j);
     }
        return a;
    }
    private void swap (int [] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
// s2
// use Fisher-Yates Algorithm 
// 56 ms (86%) 48 Mb (98%), both in O(n)

class Solution {
    private int [] nums;
    private Random random;

    public Solution(int[] nums) {
    this.nums = nums;
    random = new Random();
    }

    public int[] reset() {
    return nums;
    }

    public int[] shuffle() {
     if (nums ==null)
         return null;
     int [] a = nums.clone();
     int arrayLength = a.length;
     for (int i=0;i<arrayLength;i++) {
         //int i = random.nextInt(j+1);
         swap(a,i,randRange(i,arrayLength));
     }
        return a;
    }
    private void swap (int [] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}


