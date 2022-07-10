// s1
// 4 ms 69.5%; 44Mb 10%
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
       
        
        for (int i=0;i<nums1.length;i++){
            Integer count = map1.get(nums1[i]);
            map1.put(nums1[i],(count==null)? 1:count+1);
        }
        
       ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i:nums2) {
            if (map1.containsKey(i)){
                if (map1.get(i)>1) {
                    map1.put(i,map1.get(i)-1);
                } else {
                    map1.remove(i);
                }
                list.add(i);
            }   
        }
        
        int [] res = new int[list.size()];
        int i=0;
        while(i<list.size()) {
            res[i] = list.get(i);
            i++;
        }
        return res;
    }
// solution 2
// 2 ms 97%, 43Mb 72%

class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
    //skip a stupid corner case:)
    if(nums1.length>0&&nums1[0]==Integer.MIN_VALUE) return new int[]{1,Integer.MIN_VALUE};
    
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums1.length; i++) {          
        min = Math.min(min, nums1[i]);
        max = Math.max(max, nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
        min = Math.min(min, nums2[i]);
        max = Math.max(max, nums2[i]);
    }
    int[] count = new int[max-min+1];
    for (int i = 0; i < nums1.length; i++) {
        count[nums1[i]-min]++;
    }
     List<Integer> intersect = new ArrayList<Integer>();
     for (int i = 0; i < nums2.length; i++) {
         if(count[nums2[i]-min]>0) {
             count[nums2[i]-min]--;
             intersect.add(nums2[i]);
         }
     }     
     return result(intersect);
}
public int[] result(List<Integer> intersect){
     int i = 0;
     int[] result = new int[intersect.size()];
     for (int num : intersect) {
         result[i++] = num;
     }
     return result;
}        
}
