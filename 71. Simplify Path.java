// 3 ms : use StringBuilder and LinkedList
class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        String [] p = path.split("/");
        System.out.println(Arrays.toString(p));
        StringBuilder sb = new StringBuilder();
        LinkedList<String> s = new LinkedList<>();
        for(String pa:p)
            if (pa.equals("..")) {
             if (!s.isEmpty())
                s.removeLast();
            } else if (pa.equals("/") || pa.equals("."))
                continue;
            else if (pa.length()>0)
                s.add(pa);
        System.out.println(s);
        while(!s.isEmpty())
            sb.append("/").append(s.pollFirst());
        if (sb.length()==0)
            sb.append("/");
        return sb.toString();
    }
}

// Solution 2
class Solution {
    public String simplifyPath(String path) {
        if (path==null) {
            throw new IllegalArgumentException("Input string is null");
        }
        
        if (path.length()<=1) {
            return "/";
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        int i =0;
        int len = path.length();
        
        while (i<len) {
            if (path.charAt(i) =='/') {
                i++;
                continue;
            }
            
           StringBuilder dir = new StringBuilder();
            while (i<len && path.charAt(i)!='/' ) {
                dir.append(path.charAt(i));
                i++;
            }
                   
            String dirName = dir.toString();
                   switch(dirName) {
                       case ".":
                       break;
                       case "..":
                           if (!stack.isEmpty()) {
                               sb.setLength(stack.pop());
                           }
                       break;
                       default:
                       stack.push(sb.length());
                       sb.append('/').append(dirName);
                   }
                }
          return sb.length() !=0? sb.toString(): "/";
    }
}
