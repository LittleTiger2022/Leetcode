// s1: top down recursion
// 1ms 44Mb (O(n^2))
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}

// solution 2: bottom up approach,
//1ms 44Mb (O(n))
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) !=-1;
    }
    public int dfsHeight(TreeNode root) {
        if (root ==null) return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight==-1) return -1;
        
        int rightHeight = dfsHeight(root.right);
        if (rightHeight==-1) return -1;
             
        if (Math.abs(leftHeight - rightHeight)>1) return -1;
             return Math.max(leftHeight,rightHeight) +1;
    }
}
