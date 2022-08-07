//BFS
// 2 ms (98%) 47Mb 49%
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root==null)
            return res;
        
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        
        que.add(root);
        
        while(!que.isEmpty()) {
            int count = que.size();
            double sum=0.0;
            for (int i=0;i<count;i++) {
                TreeNode tn = que.poll();
                sum+= tn.val;
                if (tn.left!=null) 
                    que.add(tn.left);
                if (tn.right!=null)
                    que.add(tn.right);
            }
            res.add(sum/count);
        }
        return res;
    }
}
//
// DFS
// 2ms (98.5%) 47.6Mb (62%)
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        
        average(root,0,res,count);
        for (int i=0;i<res.size();i++)
            res.set(i,res.get(i)/count.get(i));
        return res;
    }
    
    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t==null)
            return;
        if (i<sum.size()) {
            sum.set(i,sum.get(i)+t.val);
            count.set(i,count.get(i)+1);
        } else {
            sum.add(1.0*t.val);
            count.add(1);
        }
        average(t.left,i+1,sum,count);
        average(t.right,i+1,sum,count);
    }
}

