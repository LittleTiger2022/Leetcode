// my naive solution
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length()==1) 
            return true;
        int left =0, right = s.length()-1;
        
        while(left<right) {
            
            while(left<right &  !((s.charAt(left)>='a' && s.charAt(left)<='z' ) ||
                (s.charAt(left)>='A' && s.charAt(left)<='Z' ) ||
                (s.charAt(left)>='0' && s.charAt(left)<='9' ) ))
            {
               left++; 
            }
             while(left<right & !((s.charAt(right)>='a' && s.charAt(right)<='z' ) ||
                (s.charAt(right)>='A' && s.charAt(right)<='Z' ) ||
                (s.charAt(right)>='0' && s.charAt(right)<='9' ) ))
            {
               right--; 
            }
            char chL = s.charAt(left);
            char chR = s.charAt(right);
            if (chL>'Z') chL = (char) ( chL- 'a'+'A');
            if (chR>'Z') chR = (char) ( chR- 'a'+'A');
       //  System.out.println("Left = " + chL + " right = " + chR);

            if(chL!=chR)
            {
                return false;
                
            }
            else {
                left ++;
                right--;
            }
        }
                    return true;

    }
}
// 4ms from LeetCode 前400题Java精美版
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int head=0,tail=s.length()-1;
        char cHead,cTail;
        while (head<tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead)!= Character.toLowerCase(cTail))
                    return false;
                head++;
                tail--;
            }
        }
        return true;
    }
}
// 882 ms (use system function)
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+","");
        s= s.toLowerCase();
        int left=0,right=s.length()-1;
        while (left<right) {
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
