// s1
// 1 ms 29%

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)
            return 0;
        
        int sum=0;
        if (root.left!=null) 
            if (root.left.left==null & root.left.right==null)
                sum += root.left.val;
            else
                sum+=sumOfLeftLeaves(root.left);
            
        if (root.right!=null)
            sum+=sumOfLeftLeaves(root.right);
        return sum;
    }
    
}

//s2
// 0 ms
class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root);
        return sum;
    }
    public void preOrder(TreeNode root){
        if(root==null ){
            return;
        }
        if( root.left!=null){
            if(root.left.left==null && root.left.right==null){
                sum+=root.left.val;
            }
        }
        preOrder(root.left);
        preOrder(root.right);
    }
}
