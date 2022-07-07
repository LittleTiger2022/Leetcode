// s1
// 14 ms(32%) 42Mb(76%)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root != null)
        Helper(root,"",res);
        return res;
    }
    public void Helper(TreeNode root, String path, List<String>res) {
        if (root.left==null && root.right==null)
            res.add(path+root.val);
        
        if (root.left!=null)
            Helper(root.left,path+root.val+"->",res);
        if (root.right!=null)
            Helper(root.right,path+root.val+"->", res);
    }
    
}
// s2: further optimized with StringBuilder
// 1 ms (100%) and 40 Mb (99%)
class Solution {
 public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}

