// s1
// 11 ms (21%)
/*
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.

*/
class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
       if(num == 0) return "0";
       String result = ""; 
        
       while(num != 0){
        result = map[(num & 15)] + result;
        num = (num >>> 4);
    }

    return result; 
    }
}
// very smart solution
// 0 ms 100% 40 Mb 89%
class Solution {
     public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int n = num & 0xf;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
        } while ((num >>>= 4) != 0); 
        return sb.reverse().toString();
    }
}
