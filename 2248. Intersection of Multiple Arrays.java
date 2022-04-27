// brutal force approach
// 7 ms
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int nArray = nums.length;
        // if (nArray==1) return nums[0];
        // find array with the min numbers
        int minNumber = nums[0].length, minNumberArrayID=0;
        for (int i=1;i<nArray;i++) {
            if (nums[i].length<minNumber) {
            minNumber = nums[i].length;
                minNumberArrayID = i;
            }
        }
        int [] common = new int[minNumber];
        for (int i=0;i<minNumber;i++) common[i] = nums[minNumberArrayID][i];
        int nCommon = common.length;
        Boolean[] boolArray = new Boolean[nCommon]; // initialize a boolean array

        List <Integer> ans = new ArrayList<>();
        Arrays.sort(common);
        for (int j=0;j<nCommon;j++) {
            boolArray[j] = true;
        for (int i=0;i<nArray;i++){
            Boolean tempBool = false;
             for (int k=0; k<nums[i].length;k++) {
                 if (nums[i][k]==common[j]) {tempBool=true; break;}
             }
            boolArray[j] = boolArray[j] & tempBool;
        }
            if(boolArray[j]==true) ans.add(common[j]);
        }
        
        return ans;
    }
}

// a simpler solution (if this number existing in every array, the map value should equal to the numbers of arrays)
// 2ms
class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        int[] count  = new int[1001];
        
        for(int[] arr : nums){
            for(int i : arr){
                count[i]++;
            }
        }
        
       for(int i=0;i<count.length;i++){
           if(count[i]==nums.length){
               ans.add(i);
           }
       }
        
        return ans;
    }
}
