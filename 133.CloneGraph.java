// s1
class Solution {
    
    Map<Node,Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node,newNode);
        for (Node next: node.neighbors) {
            Node neighborNode = cloneGraph(next);
            newNode.neighbors.add(neighborNode);
        }
        return newNode;
    }
}

// s2

class Solution {
    public Node cloneGraph(Node node) {
     Node root = new Node(node.val, new ArrayList<Node>());
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<Integer,Node>();
        map.put(node.val,root);
        q.offer(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nb:cur.neighbors) {
                if (!map.containsKey(nb.val)) {
                    map.put(nb.val,new Node(nb.val,new ArrayList<Node>()));
                    q.offer(nb);
                }
                map.get(cur.val).neighbors.add(map.get(nb.val));
            }
            
        }
        return root;
    }
}
