//  17 ms 
public class Codec {
    static int i=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString().trim();
    }
    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root==null) {
            sb.append("# ");
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        serialize(root.left,sb);
        serialize(root.right,sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] vals = data.split(" ");
        i=0;
        return deserialize(vals);
    }
    private static TreeNode deserialize(String [] vals) {
        String val = vals[i++];
        if ("#".equals(val))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        if (i<vals.length-1)
            root.left = deserialize(vals);
        if (i<vals.length-1)
            root.right = deserialize(vals);
        return root;
    }
    
}

