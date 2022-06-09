// seperate the list into two halfs, reverse the second half
// if the list is odd, skip the middle. Compare the first half and the reversed second half
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast !=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast!=null) // odd 
            slow = slow.next;
        slow = reverse(slow);
        fast = head;
        while(slow!=null) {
            if (fast.val!=slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
