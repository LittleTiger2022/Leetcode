//s1
// 7 ms 84%; 63Mb 78%
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] record = new int [nums.length];
        for (int i=0;i<nums.length;i++)
            record[nums[i]-1]++;
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++)
            if (record[i]==0)
                res.add(i+1);
        return res;
    }
}
