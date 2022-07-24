// s1
// 2 ms (71%) 
public class Solution {
     public boolean isAdditiveNumber(String num) {
         int len = num.length();
         for(int i = 1; i <= len/2; i++){
             for(int j = 1; Math.max(i,j) <= len-i-j;j++){
                 if(isValid(i,j,num)) return true;
             }
         }
         return false;
     }
     
     public boolean isValid(int i,int j,String num){
         if(num.charAt(0) == '0' && i > 1) return false;
         if(num.charAt(i) == '0' && j > 1) return false;
         String sum;
         Long one = Long.parseLong(num.substring(0,i));
         Long two = Long.parseLong(num.substring(i,i+j));
         for(int s = i+j; s < num.length(); s += sum.length()){
             two = two + one;
             one = two - one;
             sum = two.toString();
             if(!num.startsWith(sum,s)) return false;
         }
         return true;
     }
 }
