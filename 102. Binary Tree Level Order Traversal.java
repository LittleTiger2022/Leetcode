// 1ms 42.5mb BFS (Breath-First Search)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List <Integer>> result = new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                if (current.left!=null) {
                    queue.add(current.left);
                }
                if (current.right!=null){
                    queue.add(current.right);
                }
                
            }
            result.add(currentLevel);
        }
        return result;
    }
}

// 0ms, 42Mb DFS (Depth-First-Search)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List <Integer>> result = new ArrayList<>();
                levelHelper(result, root, 0);
        return result;
    }
     public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
    
}
