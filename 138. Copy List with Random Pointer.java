// 1ms, 33%
// O(N) traverse the original node twice. the first time, use Map to record new Node. For the second time, use Map to add next and random to the new Node
class Solution {
    public Node copyRandomList(Node head) {
        
       Map<Node,Node> map = new HashMap<>();
       Node node = head, ans, newNode;
           while(node!=null) {
               map.put(node, new Node(node.val,node.next,node.random));
               node = node.next;
           }
           node = head;
           newNode = map.get(node);
           ans = newNode;
           while (node!=null) {
               newNode.val = node.val;
               newNode.next = map.get(node.next);
               newNode.random = map.get(node.random);
               newNode = newNode.next;
               node = node.next;
           }
     return ans;
    }
}
// 0 ms 
// do not use extra space. traverse three times.
class Solution {
    public Node copyRandomList(Node head) {
        if (head ==null)
            return null;
      // first, copy original element. next point to new next.
        Node current = head;
        while (current !=null) {
            Node temp = current.next;
            current.next = new Node(current.val,temp,null);
            current = temp;
        }
      // second, random point to original random next
        current = head;
        while (current!=null) {
            if (current.random!=null)
                current.next.random = current.random.next;
            current = current.next.next;
        }
      // third, let new Node be independent
        current = head;
        Node copyList = head.next;
        while (current!=null) {
            Node copy = current.next;
            Node next = current.next.next;
            current.next = copy.next;
            if (next!=null)
                copy.next = next.next;
            current = next;
        }  
        return copyList;
    }
}
// much simpler and elegent solution
// 0 ms (100%, 98%)
class Solution {
    public Node copyRandomList(Node head) {
        Map <Node, Node> map = new HashMap<>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node!=null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node!=null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
// original c++ solution
// 12 ms
class Solution {
public:
    Node* copyRandomList(Node* head) {
       map<Node*, Node*> m;
        int i=0;
        Node* ptr = head;
        while (ptr) {
            m[ptr] =new Node(ptr->val);
            ptr = ptr->next;
        }
        ptr = head;
        while (ptr) {
            m[ptr]->next = m[ptr->next];
            m[ptr]->random = m[ptr->random];
            ptr = ptr->next;
        }
        return m[head];  
    }
};
