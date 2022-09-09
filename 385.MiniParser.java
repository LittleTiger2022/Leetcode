//s1
// classical stack problem
// 6 ms (77%) 45Mb (77%)

class Solution {
    public NestedInteger deserialize(String s) {
    if (!s.startsWith("["))
        return new NestedInteger(Integer.valueOf(s));
    NestedInteger ni = new NestedInteger();
        int i =0;
        int open = 0;
        int start = -1;

        while(i<s.length()) {
            char c = s.charAt(i);
            i++;
            if (open==1 && (Character.isDigit(c) || c=='-')) {
                int num=0;
                if (c!='-')
                    num=c-'0';
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    num = num*10+s.charAt(i)-'0';
                    i++;
                }
                if (c=='-')
                    num = -num;
                ni.add(new NestedInteger(num));
            } else if (c=='[') {
                if (open==1)
                    start = i-1;
                open++;
            } else if (c==']') {
                open--;
                if (open==1)
                    ni.add(deserialize(s.substring(start,i)));
            }
            }
            return ni;
        }
    }

