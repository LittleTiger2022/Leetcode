// 
class Solution {
    public Node connect(Node root) {
        if (root==null) return null;
        Node current=root;
        
        while(current.left!=null) {
            Node nextLevel = current.left;
            
            while (current!=null) {
                current.left.next = current.right;
            
            if (current.next==null)
                current.right.next=null;
            else
                current.right.next = current.next.left;
            current = current.next;
        }
            current = nextLevel;
        }
        return root;
    }
}

//
class Solution {
    public Node connect(Node root) {
        if (root ==null) return null;
        Node pre = root;
        Node cur = null;
        while (pre.left!=null) {
            cur = pre;
            while (cur!=null) {
                cur.left.next = cur.right;
                if (cur.next!=null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
