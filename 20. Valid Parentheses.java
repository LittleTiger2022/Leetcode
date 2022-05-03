// method 1 HashMap and stack
// 2ms
    public boolean isValid(String s) {
        Map<Character,Character> m = new HashMap<>();
        m.put('(',')');
        m.put('[',']');
        m.put('{','}');
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (m.containsKey(c))
                st.push(m.get(c));
            else if (st.isEmpty() || st.pop()!=c)
                return false;
        }
        return st.isEmpty();
    }

// method only use stack
  public boolean isValid(String s) {
        if (s.length() % 2 !=0) return false;
        Stack <Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c=='('|| c =='[' || c=='{')
            {stack.push(c);}
            else if(c==')' && !stack.isEmpty() && stack.peek()=='(') 
            {stack.pop();}
            else if(c==']' && !stack.isEmpty() && stack.peek()=='[') 
            {stack.pop();}
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{')
            {stack.pop();}
            else stack.push(c);
        }
        return stack.isEmpty();
    }

// simple code (5ms)
class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<Character>();
        for (char ch: s.toCharArray()) {
            if (ch=='(')
                stack.push(')');
            else if (ch=='{')
                stack.push('}');
            else if (ch=='[')
                stack.push(']');
            else if (stack.isEmpty() || ch!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
