// s1
//
class Solution {
     public void reorderList(ListNode head) {
        if (head ==null || head.next==null)
            return;
        
        // step 1: find the middle point
        ListNode slow= head, fast = head.next;
             
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // step 2: reverse the second half        
        ListNode pM=slow, pC = slow.next;
        while (pC.next!=null) {
            ListNode cur = pC.next;
            pC.next = cur.next;
            cur.next = pM.next;
            pM.next = cur;
        }
        
         
       // step 3: merge
            ListNode  p1=head;
            ListNode p2=pM.next;
            while(p1!=pM){
                pM.next=p2.next;
                p2.next=p1.next;
                p1.next=p2;
                p1=p2.next;
                p2=pM.next;
            }
    }
}
