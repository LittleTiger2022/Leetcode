// s1
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.add(x);
        for (int i=0;i<queue.size()-1;i++) {
            queue.add(queue.poll());
        }
    }
    
    public int pop() {
      //  return queue.poll();
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
        
    }
}
// s2 with two queues
// push: directly add the value at the end and make it top
// Pop: remove all elements of queue except last element and add them to another queue, now swap the queues
class MyStack {

   private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public MyStack() {
        
    }
    
    public void push(int x) {
        top=x;
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size()>1)
        {
            top=q1.remove();
            q2.add(top);
        }
        int removed = q1.remove();
        Queue<Integer> q =q1;
        q1 =q2;
        q2 =q;
        return removed;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

}

