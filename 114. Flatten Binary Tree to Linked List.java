// s1
class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        helper(root);
    }
    void helper(TreeNode root) {
        if (root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (pre!=null) {
            pre.left =null;
            pre.right = root;
        }
        pre = root;
        helper(left);
        helper(right);
    }
}

// s2: no need global variable
class Solution {
     public void flatten(TreeNode root) {
        root = helper(root, null);
    }
    // helper function takes in the previous head, do the flattening and returns the head of the flatten binary tree
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }
}
