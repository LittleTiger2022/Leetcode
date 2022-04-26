// 0 ms
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int l1 = getlength(head);
        if (l1==1) return head;
        
        int secondMid = l1/2;
        ListNode result = head;
        int count=0;
        while (head!=null)
        {
            head= head.next;
            count++;
            if (count>=secondMid) {
               // System.out.println(count);

                result =  head;
                break;
            }
        }
        
       return result;
    }
    public int getlength(ListNode head) {
        int count=0;
        while (head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
