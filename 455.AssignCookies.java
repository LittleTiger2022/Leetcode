// s1 My naive solution
// O(n)  13ms 35% 54Mb 
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int res =0, childPoint=0;
        if (s.length<1 | g.length<1)
            return res;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        for (int i=0;i<g.length;i++) {
           // System.out.println("i = " + i);
            while (childPoint<s.length && s[childPoint]<g[i]) {
                childPoint++;
            }
         //   System.out.println("childPoint = " + childPoint);
            if (childPoint<s.length &&  s[childPoint]>=g[i])  { 
                res++;
                childPoint++;
                
            }
     //       System.out.println("res = " + res);
        }
        return res;
    }
}
// s2:
// 10 ms 75% 53Mb 50%
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        for (int cookie = 0; child < g.length && cookie < s.length; cookie ++) {
            if (s[cookie] >= g[child]) {
                child ++;
            }
        }
        
        return child;  
    }
}
//

