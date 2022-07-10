// s1a(3 ms)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for (int i=0;i<nums1.length;i++)
                set.add(nums1[i]);
        
        for (int i=0;i<nums2.length;i++)
                if (set.contains(nums2[i]))
                    intersect.add(nums2[i]);
        int [] res = new int[intersect.size()];
        int i=0;
        for(Integer num:intersect)
            res[i++] = num;
        return res;
    }
}

// s2 (4ms 72%)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for (int i=0;i<nums1.length;i++)
                set.add(nums1[i]);
        
        for (int i=0;i<nums2.length;i++)
                if (set.contains(nums2[i]))
                    intersect.add(nums2[i]);
        
    return intersect.stream().mapToInt(Integer::intValue).toArray();
    }
}
// solution 3

// 6 ms
// time complex O(n+m), space complex O(n+m)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for (int i=0;i<nums1.length;i++)
            set1.add(nums1[i]);
        for (int i=0;i<nums2.length;i++)
            set2.add(nums2[i]);
        
        if(set1.size()<set2.size()) return set_intersection(set1,set2);
        else return set_intersection(set2,set1);
    }
    
    public int [] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
      int [] output = new int[set1.size()];
        int idx =0;
        for(Integer s:set1)
            if (set2.contains(s))
                output[idx++] = s;
        return Arrays.copyOf(output,idx);
    }
}

// s4: use retainAll (built-in intersection facilities)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for (int i=0;i<nums1.length;i++)
            set1.add(nums1[i]);
        for (int i=0;i<nums2.length;i++)
            set2.add(nums2[i]);
     
        set1.retainAll(set2);
        
        return set1.stream().mapToInt(Integer::intValue).toArray();

    }
}
// s5:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for (int i=0;i<nums1.length;i++)
            set1.add(nums1[i]);
        for (int i=0;i<nums2.length;i++)
            set2.add(nums2[i]);
     
        set1.retainAll(set2);
        
        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s: set1) output[idx++] = s;
        return output;
    }
}

// s6: fastest one 
// use bucket sorting (shortcoming: edge case [2147483648, 1, 2147483648] could cause memory exceed
// 1 ms (99%) 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] ans = new int[nums1.length];
        int idx = 0;
        for (int i: nums1) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        for (int i: nums2) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        boolean[] map = new boolean[max - min + 1];
        for (int i : nums1) map[i - min] = true;
        for (int i : nums2) {
            if (map[i - min]) {
                ans[idx++] = i;
                map[i - min] = false;
            }
        }
        return Arrays.copyOf(ans, idx);
    }  
}
