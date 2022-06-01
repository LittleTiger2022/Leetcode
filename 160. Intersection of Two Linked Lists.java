// X+Y+Z = Y+X+Z
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        
        while (a!=b) {
            a = a == null? headB:a.next;
            b = b == null? headA:b.next;
        }
        return a;
    }
}

// easy to understand version
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      // find length of each ListNode
        int lenA =0;
        ListNode tempA = headA;
        while (tempA!=null) {
            lenA++;
            tempA = tempA.next;
        }
        int lenB =0;
        ListNode tempB = headB;
        while (tempB!=null) {
            lenB++;
            tempB = tempB.next;
        }
        
        int diff = Math.abs(lenA-lenB);
        // find the diff in lengths and move tempA or tempB to skipe the first extra nodes.
        tempA = headA;
        tempB = headB;
        
        if (lenA > lenB) {
            while (diff-- >0) 
                tempA = tempA.next;
        } else {
            while (diff-- >0)
                tempB = tempB.next;
        }
        // with A and B have equal # of nodes to the end, check for equality for intersecttion 
        while (tempA!=tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}

// use HashMap (6ms)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA!=null) {
            visited.add(headA);
            headA = headA.next;
        }
        
        while (headB!=null) {
            if (visited.contains(headB))
                return headB;
            headB= headB.next;
        }
        return null;
    }
}
