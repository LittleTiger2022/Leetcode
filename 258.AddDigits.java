// Digit Root 
// s1
// O(logn) 3ms (16%)
class Solution {
    public int addDigits(int num) {   
        
        while (num>=10) {
            int temp=0;
            String str = Integer.toString(num);
           // System.out.println(str);
            for (int i=0;i<str.length();i++)
                temp = temp + str.charAt(i)-'0';
            // System.out.println(temp);
            num = temp;
        }
        return num;
    }
}
// s2

class Solution {
    public int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;
            
            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;  
            }    
        }     
        return digitalRoot;
    }
}
// best solution
// O(1) 1 ms
class Solution {
    public int addDigits(int num) {
     return 1 + (num-1)%9;   
    }
}

