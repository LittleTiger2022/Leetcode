// solution 1 (interviewer prefer?)
class MinStack {
	private Node head;
        
    public void push(int x) {
        if (head == null) 
            head = new Node(x, x, null);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
        
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
// solution 2
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack <Integer> stack;
    
    public MinStack() {
    stack = new Stack<>();    
    }
    
    public void push(int val) {
        if (val<=min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
       if (stack.pop()==min) {
           min = stack.pop();
       } 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
