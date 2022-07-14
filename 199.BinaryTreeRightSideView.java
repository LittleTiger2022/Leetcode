// s1
// 1ms 95%, 42Mb 72%
class Solution {
    int max = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
      if (root!=null)
           dfs(root,0,res);
        return res;
    }
    
    public void dfs(TreeNode root, int level, List<Integer> ans) {
        if (level >max) {
            max = level;
            ans.add(root.val);
        }
        
        if (root.right != null)
            dfs(root.right, level+1, ans);
        if (root.left!=null)
            dfs(root.left,level+1,ans);
    }
}

// s2:
// 1ms 95%, 43Mb 41%
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>(), nq = new LinkedList<>();
        if (root!=null)
            q.offer(root);
        while(!q.isEmpty()) {
            root = q.poll();
            if (root.left!=null)
                nq.offer(root.left);
            if (root.right!=null)
                nq.offer(root.right);
            if (q.isEmpty()) {
                ans.add(root.val);
                Queue<TreeNode> temp = q;
                q = nq;
                nq = temp;
            }
         }
        return ans;
    }
}
