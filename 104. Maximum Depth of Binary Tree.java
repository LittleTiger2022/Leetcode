class Solution {
    public int maxDepth(TreeNode root) {
      return maxDepth(root,0);
        
    }
    private int maxDepth(TreeNode root, int maxD) {
        if (root==null)
            return maxD;
        return Math.max(maxDepth(root.left,maxD+1), maxDepth(root.right,maxD+1));
    }
}
