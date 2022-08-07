// s1: my naive solution
// recursive 
// 2ms 98% 44.9Mb 76%
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
public void helper(TreeNode root, StringBuilder sb) {
    if (root==null)
        return;
    sb.append(root.val);
    if (root.left!=null) {
        sb.append("(");
         helper(root.left,sb);
        sb.append(")");
        }
    if(root.left==null & root.right!=null)
        sb.append("()");
    if(root.right!=null) {
        sb.append("(");         
        helper(root.right,sb);
        sb.append(")");
    }
}
}
// s2: use stack
// 16 ms (72%) 47.6Mb (62%)
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}
// s3: Leetcode Recursion
// 30 ms (46%) 54Mb (50%)
public class Solution {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
}
