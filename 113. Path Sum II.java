// s1
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root,0,targetSum,res, new ArrayList<Integer>());
        return res;
    }
    void dfs(TreeNode root,int curSum, int targetSum, List<List<Integer>> res,  List<Integer> can) {
        if (root==null)
            return;
        
        if (root.left==null && root.right==null && curSum + root.val==targetSum) {
            List<Integer> an = new ArrayList(can);
            an.add(root.val);
            res.add(an);
        }
        else {
        curSum+=root.val;
        can.add(root.val);    
        dfs(root.left,curSum,targetSum,res,can);
        dfs(root.right,curSum,targetSum,res,can);
            can.remove(can.size()-1);
        }
    }
}
