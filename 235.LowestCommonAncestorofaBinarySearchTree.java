//

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) *(root.val-q.val)>0)
            root = p.val < root.val? root.left: root.right;
        return root;
    }
}

// s2
Class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
           return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
           return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
