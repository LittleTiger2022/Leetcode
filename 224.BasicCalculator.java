//s1
// 6 ms (94%) 42Mb (89%)
class Solution {
    public int calculate(String s) {
        char [] cs = s.toCharArray();
        int result =0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<cs.length;++i) {
            char c = cs[i];
            switch (c) {
                case '+' :
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                    break;
                case ')':
                    result = stack.pop()*result+stack.pop();
                    break;
                default:
                   int cur = 0;
                   if (Character.isDigit(c)) {
                       cur = c-'0';
                       while (i+1<cs.length && Character.isDigit(cs[i+1]))
                           cur = cur*10+(cs[++i]-'0');
                   }
                   result+= cur *sign;
                   break;            
            }
        }
        return result;
    }
}
//
