// s1

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      Queue<TreeNode> q = new LinkedList<>(), nq = new LinkedList<>();
      List<Integer> can = new ArrayList<>();
        
        if (root!=null)
            q.offer(root);
        while (!q.isEmpty()) {
            TreeNode c = q.poll();
            can.add(c.val);
            if (c.left!=null)
                nq.offer(c.left);
            if (c.right!=null)
                nq.offer(c.right);
            if (q.isEmpty()) {
                ans.add(0, new ArrayList(can));
                can = new ArrayList<>();
                if (!nq.isEmpty()) {
                    Queue<TreeNode> temp =q;
                    q = nq;
                    nq = temp;
                }
            }
        }
        return ans;
    }
}
