//s1 : use stack
// 1ms (89%) 40Mb (96%)

class Solution {
    public String decodeString(String s) {
        var ans = new StringBuilder();
        char [] c = s.toCharArray();
        int n = c.length;
        Stack<Integer> cnt = new Stack<Integer>();
        Stack<String> str = new Stack<String>();
        for (int i=0;i<n;++i) {
            if (Character.isDigit(c[i])) {
                int num=0;
                while(Character.isDigit(c[i]))
                    num = num*10 +(c[i++]-'0');
                cnt.push(num);
                --i;
            } else if (c[i]=='[') {
                str.push(ans.toString());
                ans = new StringBuilder();
            } else if (c[i]==']') {
                StringBuilder tmp = new StringBuilder(str.pop());
                int rt = cnt.pop();
                while (rt-- >0)
                    tmp.append(ans);
                ans = tmp;
            } else {
                ans.append(c[i]);
            }
        }
        return ans.toString();
    }

}

