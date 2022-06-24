//
class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root,0,targetSum);       
    }
    private boolean hasPathSum(TreeNode root, int curSum, int targetSum) {
        if (root==null)
            return false;
        curSum+=root.val;
        if (root.left==null && root.right==null)
            return curSum==targetSum;
        return hasPathSum(root.left,curSum,targetSum) || hasPathSum(root.right,curSum,targetSum);
        
    }
}
