// s1

class Solution {
    public Node connect(Node root) {
        Node pre =null, cur = root, head = null;
        while(cur!=null) {
        while(cur!=null) {
            if (cur.left!=null) {
                if (pre!=null)
                    pre.next = cur.left;
                else
                    head = cur.left;
                pre = cur.left;
        }
        if( cur.right!=null) {
            if (pre!=null)
                pre.next = cur.right;
            else
                head = cur.right;
            pre = cur.right;
        }
        cur = cur.next;
        }
        cur = head;
        pre = null;
        head = null;
    }
    return root;
}
}
// s2: resy noted
class Solution {
    public Node connect(Node root) {
      Node dummyHead  = new Node(0); // this head will always point to the first element in the current layer we are searching
      Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer   
      Node real_root = root; // just for return statement
        
      while(root != null){
          if(root.left != null){
              pre.next = root.left;
              pre = pre.next;
          }
          if(root.right != null){
              pre.next = root.right; 
              pre = pre.next;
          }
          root = root.next; 
          if(root == null){ // reach the end of current layer
              pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer  
              root = dummyHead.next; ;//root comes down one level below to the first available non null node
              dummyHead.next = null;//reset dummyhead back to default null
          }
      }
        return real_root;
    }
}
     
