//s1
// bruteforce O(n2) TLE problem

class Solution {
    public List<Integer> countSmaller(int[] nums) {
       int [] count = new int [nums.length];
         List<Integer> list = new ArrayList<>(nums.length);
        for (int i=0;i<nums.length-1;i++) {
            
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i]>nums[j])
                    count[i]++;
            }
            list.add(count[i]);
        }
        list.add(0);
        return list;
    }
}
// s2: BFS still TLE
class Solution {
    class Node {
        Node left, right;
        int val, sum, dup=1;
        public Node (int v, int s) {
            val = v;
            sum = s;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Integer [] ans = new Integer[nums.length];
        Node root = null;
        for (int i=nums.length-1;i>=0;i--) {
            root = insert(nums[i],root, ans,i,0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node==null) {
            node = new Node(num,0);
            ans[i] = preSum;
        } else if (node.val==num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val>num) {
            node.sum++;
            node.left=insert(num,node.left,ans,i,preSum);
        } else {
            node.right = insert(num,node.right, ans, i, preSum+node.dup+node.sum);
        }
        return node;
    }
}

// s3: workable, segment tree
// 225 ms 44.8%	140Mb 26%
public class Solution {
    class SegTreeNode {
        int min, max; // range [min, max]
        int count;
        SegTreeNode left, right;
        
        public int mid() {
            return ((max + 1 - min) / 2 + min);
        }
        
        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }
        
        SegTreeNode root = new SegTreeNode(min, max);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
            add(nums[i], root);
        }
        
        return list;
    }
    
    private int find(int x, SegTreeNode root) {
        if (root == null) return 0;
        
        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid(); 
            if (x < mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }
    
    private void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max) return;
       
        root.count++;
        if (root.max == root.min) return;
        
        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) {
                root.left = new SegTreeNode(root.min, mid - 1);
            }
            add(x, root.left);
        } else {
            if (root.right == null) {
                root.right = new SegTreeNode(mid, root.max);
            }
            add(x, root.right);
        }
    }
}

// s4: merge sorting
// 122 ms
public class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        int len = (nums == null? 0 : nums.length);
        
        int[] idxs = new int[len];
        int[] count = new int[len];
        
        for (int i = 0; i < len; i++) idxs[i] = i;
        
        mergeSort(nums, idxs, 0, len, count);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : count) list.add(i);
        
        return list;
    }
    
    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
        if (start + 1 >= end) return;
        
        int mid = (end - start) / 2 + start;
        mergeSort(nums, idxs, start, mid, count);
        mergeSort(nums, idxs, mid, end, count);
        
        merge(nums, idxs, start, end, count);
    }
    
    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
        int mid = (end - start) / 2 + start;
        
        int[] tmp = new int[end - start];
        int[] tmpidx = new int[end - start];
        int i = start, j = mid, k = 0;
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    tmpidx[k] = idxs[j];
                    tmp[k++] = nums[j++];
                } else {
                    count[idxs[i]] += j - mid; // add those already counted
                    tmpidx[k] = idxs[i];
                    tmp[k++] = nums[i++];
                }
                
            } else {
                tmpidx[k] = idxs[j];
                tmp[k++] = nums[j++];
            }
        }
        
        System.arraycopy(tmpidx, 0, idxs, start, end - start);
        System.arraycopy(tmp, 0, nums, start, end - start);
    }
}

// s5: Binary index tree
// 40 ms (85%)
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}
