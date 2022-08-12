// DFS
//  3ms (95%) 42Mb (97%)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet <Integer> set = new HashSet<>();
        return dfs(root,set,k);
    }
    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root==null)
            return false;
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        return dfs(root.left,set,k) || dfs(root.right,set,k);
    }
}

// s2: BFS
// the same performance
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            if (queue.peek()!=null) {
                TreeNode cur = queue.poll();
                if (set.contains(k-cur.val))
                    return true;
                set.add(cur.val);
                queue.add(cur.right);
                queue.add(cur.left);
            } else 
                queue.poll();
        }
        return false;
    }
}
