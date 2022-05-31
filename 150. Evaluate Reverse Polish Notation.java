// classic stack problem
// 9ms
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

// solution 2 without using stack
 3ms 99%
public int evalRPN(String[] tokens) {
 int[] ls = new int[tokens.length/2+1];
    int index = 0;
    for (String token : tokens) {
        switch (token) {
            case "+":
                ls[index - 2] = ls[index - 2] + ls[index - 1];
                index--;
                break;
            case "-":
                ls[index - 2] = ls[index - 2] - ls[index - 1];
                index--;
                break;
            case "*":
                ls[index - 2] = ls[index - 2] * ls[index - 1];
                index--;
                break;
            case "/":
                ls[index - 2] = ls[index - 2] / ls[index - 1];
                index--;
                break;
            default:
                ls[index++] = Integer.parseInt(token);
                break;
        }
    }
    return ls[0];
}
