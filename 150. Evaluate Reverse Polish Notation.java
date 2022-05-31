// classic stack problem
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a,b;
        for (String t:tokens) {
            if ("+".equals(t))
                s.push(s.pop() + s.pop());
            else if ("-".equals(t))
                s.push(0 - s.pop() + s.pop());
            else if ("*".equals(t))
                s.push(s.pop()*s.pop());
            else if ("/".equals(t)) {
                a = s.pop();
                b = s.pop();
                s.push(b/a);
            }
            else
                s.push(Integer.valueOf(t));
        }
        return s.pop();
    }
}
