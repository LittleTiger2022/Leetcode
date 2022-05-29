//54ms
class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0, peak=0;
        Set<Integer> dict = new HashSet<>();
        for (int num:nums)
            dict.add(num);
                System.out.println(dict);

        for (int num:nums) {
                System.out.println(dict + " max = " + max);

            if (dict.remove(num)) {

                peak = 1;
                int l = num-1, r=num+1;
                                System.out.println( " num = " + num + " l = " + l + " r = " + r);

                while(dict.remove(l--)) 
                    peak++;
                                          System.out.println(dict + " peak = " + peak + " l = " + l);

                while(dict.remove(r++))
                peak++;
                                          System.out.println(dict + " peak = " + peak + " r = " + r);

                max = Math.max(peak,max);   
            }
        }
        return max;
    }
}
