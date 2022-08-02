// recursive 
// 1 ms
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        
        if (list1.val<list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1,list2.next);
        return list2;
    }
// solution 2
// use a new ListNode
// 1ms 83% 44Mb (5%)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null && list2==null)
            return null;
        if (list1==null && list2!=null)
           return list2;
        if (list1!=null & list2==null)
            return list1;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1!=null && list2!=null) {
            if (list1.val<=list2.val)
            {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
                
            }
            }
        
            if (list1!=null)
                cur.next = list1;
            if (list2!=null)
                cur.next = list2;

        return dummy.next;
    }
}    
