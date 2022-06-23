// my naive solution
// O(N) recursive 0ms, 100% & 5.18% in memory
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
           }
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p==null & q == null)
            return true;
        if ((p==null & q!=null) || (p!=null & q==null))
            return false;
        boolean Same = true;
        if (p.val!=q.val)
            Same =  false;
        Same = Same & isSame(p.left,q.left);
        Same = Same & isSame(p.right,q.right);
        return Same;
    }
}
// Solution 2: concise recursive
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p==null || q ==null || p.val!=q.val )
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
//Solution 3: My cleaned up solution
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
           }
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p==null & q == null)
            return true;
        if (p==null || q==null || p.val !=q.val)
            return false;
        return isSame(p.left,q.left) & isSame(p.right,q.right);
    }
}
