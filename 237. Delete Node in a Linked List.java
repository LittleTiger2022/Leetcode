// my solution
// O(n) 0 ms
class Solution {
    public void deleteNode(ListNode node) {
        while (node.next!=null) {
            ListNode temp = node.next;
            node.val = temp.val;
            if (node.next.next==null) {
                node.next = null;
                break;
            } else 
            node = node.next;
            
        }
       
    }
}

// easy solution (2 lines)
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

}
