// my navie solution
// 1 ms 48% (5%in space)
 class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null)
            return res;
        if (root.right==null && root.left==null) {
         res.add(root.val);
            return res;
        }
        else 
           helper(res,root);
        return res;
    }
        private void helper( List<Integer> res, TreeNode root) {
         if (root==null)
             return;
            res.add(root.val);
            helper(res,root.left);
            helper(res,root.right);
        }
}   


// s2: use stack (iteration)
// 1 ms 48% (47% in space)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s  = new Stack<>();
        
        if (root!=null)
            s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            while (cur!=null) {
                ans.add(cur.val);
                if (cur.right!=null)
                    s.push(cur.right);
                cur = cur.left;
            }
        }
        return ans;
    }
} 
