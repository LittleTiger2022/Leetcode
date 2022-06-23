// my naive solution
// O(N) recursive 0ms, 100% & O(nlogn) 5.18% in memory
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

// offical 2nd solution: Iteration using ArrayDeque
// O(N) , space: O(log(N))
class Solution {
  public boolean check(TreeNode p, TreeNode q) {
    // p and q are null
    if (p == null && q == null) return true;
    // one of p and q is null
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return true;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (!check(p, q)) return false;

    // init deques
    ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
    ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
    deqP.addLast(p);
    deqQ.addLast(q);

    while (!deqP.isEmpty()) {
      p = deqP.removeFirst();
      q = deqQ.removeFirst();

      if (!check(p, q)) return false;
      if (p != null) {
        // in Java nulls are not allowed in Deque
        if (!check(p.left, q.left)) return false;
        if (p.left != null) {
          deqP.addLast(p.left);
          deqQ.addLast(q.left);
        }
        if (!check(p.right, q.right)) return false;
        if (p.right != null) {
          deqP.addLast(p.right);
          deqQ.addLast(q.right);
        }
      }
    }
    return true;
  }
}
