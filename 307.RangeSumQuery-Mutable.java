// s1
// TLE time complex = O(n)
class NumArray {
    private int [] sums;
    public NumArray(int[] nums) {
        
        sums = new int[nums.length+1];
        for (int i=0;i<nums.length;i++)
            sums[i+1] = sums[i] + nums[i];
        
    }
    
    public void update(int index, int val) {
        int diff = val - sums[index+1] + sums[index];
        for (int i=index+1;i<sums.length;i++)
            sums[i] += diff;
    }
    
    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}
// have to use segment tree concept
// it works like binary tree with TC in O(logn)
// 139 ms (55%) 136 Mb (20%)
// use 2*n int array to contain the segment binary tree
class NumArray {
    int [] tree;
    int n;
    
    public NumArray(int[] nums) {
        if (nums.length>0)
            n = nums.length;
            tree = new int[n*2];
            buildTree(nums);
    }
    
    private void buildTree(int [] nums) {
        for (int i=n,j=0;i<2*n;i++,j++)
            tree[i] = nums[j];
        // way to obtain element sum from bottom to top
        for (int i=n-1;i>0;i--)
            tree[i] = tree[i*2] + tree[i*2+1];
        
    }
    public void update(int index, int val) {
        index +=n;
        tree[index] = val;
        while (index>0) {
            int left = index;
            int right = index;
            if (index%2==0)
                right = index+1;
            else
                left = index -1;
            tree[index/2] = tree[left]+tree[right];
            index/=2;
        }
    }
    
    public int sumRange(int left, int right) {
        left+=n;
        right+=n;
        int sum=0;
        while(left<=right) {
            if ((left%2)==1) {
                sum +=tree[left];
                left++;
            }
            if ((right%2)==0) {
                sum+=tree[right];
                right--;
            }
            left /=2;
            right/=2;
        }
        return sum;
        }
}

// use binary indexed Tree
class NumArray {
    int [] nums;
	int[] BIT;
	int n;

    public NumArray(int[] nums) {
        this.nums = nums;

		n = nums.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++)
			init(i, nums[i]);
    }
    public void init(int i, int val) {
		i++;
		while (i <= n) {
			BIT[i] += val;
			i += (i & -i);
		}
	}

    public void update(int index, int val) {
        int diff = val - nums[index ];
		nums[index] = val;
		init(index, diff);
    }
    public int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BIT[i];
			i -= (i & -i);
		}
		return sum;
	}
    public int sumRange(int left, int right) {
        		return getSum(right)   - getSum(left - 1);
    }
}
