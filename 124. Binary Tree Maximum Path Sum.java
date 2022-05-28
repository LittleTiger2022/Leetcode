// 1ms
class Solution {
    int maxPathSum;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum =Integer.MIN_VALUE;
        helper(root);
        return maxPathSum;
    }
    
    private int helper(TreeNode node) {
         
        if (node==null)
            return 0;
            
        int left = Math.max(0,helper(node.left));
        int right = Math.max(0,helper(node.right));
        maxPathSum = Math.max(maxPathSum,left+right+node.val);
       return Math.max(left,right) + node.val;
    }
}
