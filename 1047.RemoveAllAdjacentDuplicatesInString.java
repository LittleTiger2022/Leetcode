// s1: 96 ms 46% 56Mb 36%
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek()==c) 
                stack.pop();
            else
                stack.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        String x= String.valueOf(sb.reverse());
        return x;
    }
}
//s2:
// 58 ms (64%) 54Mb 54%
public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char s : S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == s)
                stack.pop();
            else
                stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        for(char s : stack) sb.append(s);
        return sb.toString();
    }
// s3: 14 ms (86%) 48Mb (79%)
class Solution {
    public String removeDuplicates(String S) {
        // consider this array as a stack, index 0 is the bottom of the stack
        char[] stack = new char[S.length()]; 
        // this is index in stack array for stack top, init as 0 because it is empty
        int stackTop = 0;
        
        for(int j = 0; j < S.length(); j++){
            // when stack is NOT empty(stackTop > 0) and first char in stack( stack[stackTop-1]) equals to new char in S(S.charAt(j))
            // pop stack
            if(stackTop  > 0 && stack [stackTop - 1] == S.charAt(j)){
                stackTop--;
            }
            // if new char in S is not equal to top of stack, push new char into stack
            else{
                stack [stackTop] = S.charAt(j);
                stackTop++;
            }
        }
        // create result string from bottom of stack to top
        return new String(stack, 0, stackTop);
    }
}
