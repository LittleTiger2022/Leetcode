// inorder traversal
// method 1: recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        if (root!=null)
            inorder(root,r);
        return r;
    }
    private static void inorder(TreeNode root, List<Integer> r) {
        if (root.left!=null)
            inorder(root.left,r);
        r.add(root.val);
        if (root.right!=null)
            inorder(root.right,r);
    }
}
// method 2:  Iterating method using Stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
         
            while (curr!=null) {
             stack.push(curr);
             curr = curr.left;
            } 
            curr = stack.pop();
            r.add(curr.val);
            curr = curr.right;
        }
        return r;
    }
}
// method 3
// Morris Traversal
// to use new data structure-Threaded Binary Tree
// strategy:
//Step 1: Initialize current as root
//Step 2: While current is not NULL,
//If current does not have left child
//    a. Add current’s value
//    b. Go to the right, i.e., current = current.right
//Else
//    a. In current's left subtree, make current the right child of the rightmost node
//    b. Go to this left child, i.e., current = current.left
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}
