//
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i=start;i<nums.length;i++) {
            if (i>start && nums[i]==nums[i-1]) {
             System.out.println("i = " + i + "  start=" + start  +  "  nums[i] = " + nums[i] + "  nums[i-1] = " + nums[i-1] +  "    " +tempList.toString());
      //        continue;
            }
            tempList.add(nums[i]);
            System.out.println("i = " + i + " " +  tempList.toString());
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
            System.out.println("i = " + i + " " +  tempList.toString());

        }
    }
}
