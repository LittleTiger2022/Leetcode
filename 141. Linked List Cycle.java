// 1ms
// use double pointer (fast and slow)
// if there is a circle, fast pointer will meet slow pointer
public class Solution {
    public boolean hasCycle(ListNode head) {
        int pos = 0;
        ListNode walker = head, runner = head;
        while (runner!=null && runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if (runner == walker)
            return true;
        }
        return false;
    }
}
// 0ms
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode x = head;
        ListNode y = head.next;
        
        while(x != y){
            if(y==null || y.next==null){
                return false;
            }
            x = x.next;
            y=y.next.next;
        }
        return true;
        
    }
}
