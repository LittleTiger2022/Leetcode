// my naive solution
// 6ms (91%) 42Mb (78%)
class Solution {
    public String reverseWords(String s) {
        char [] temp = new char [s.length()+1];
        
        int left=0, right = s.length()-1;
        while (s.charAt(left)==' ')
            left++;
        while(s.charAt(right)==' ')
            right--;
        int wordLoc = 0;
        
        for(int i=right;i>=left;i--) {
          // System.out.println(" right = " + right + " i  = " + i);
            if (s.charAt(i)==' ') {
                for(int j=0;j<right-i;j++) {
                    temp[wordLoc] = s.charAt(i+1+j);
                    wordLoc++;
                }
               // System.out.println(" temp = " + new String(temp) );
                
                right = i-1;     
         //        System.out.println(" wordLoc = " + wordLoc + " right = " + right);
                temp[++wordLoc] = ' ';
      //                  System.out.println(" temp = " + new String(temp)  );

            }
                       
            while(s.charAt(i)== ' ') {
                i--;
                right=i;
            }
        }
    //    System.out.println(" temp = " + new String(temp)  );
   //     System.out.println(" right = " + right + " left = " + left);

        for(int j=left;j<=right;j++) {
            
           temp[wordLoc] = s.charAt(j);
            wordLoc++;
        }
         String str = new String(temp).substring(0, wordLoc).replace("\u0000"," ");
       //         System.out.println(str);
        return str;
    }
}

// my cleaned version with detailed explaination for submission to the discussion section
class Solution {
    public String reverseWords(String s) {
        // use a char array to keep the reverse ordered words. Due the the removing of possible empty space, the actual size will be smaller, we need 
        // to track the true length when we return the result.
        char [] temp = new char [s.length()];
        // use left and right to mark the no-empty start and end points in the string of words.
        int left=0, right = s.length()-1;
        while (s.charAt(left)==' ')
            left++;
        while(s.charAt(right)==' ')
            right--;
        // define pointer of char array where new character will be added in
        int wordLoc = 0;
        // backward scan the string of word, and once empty space met, put the word into the char array
        for(int i=right;i>=left;i--) {
            if (s.charAt(i)==' ') {
                for(int j=0;j<right-i;j++) {
                    temp[wordLoc] = s.charAt(i+1+j);
                    wordLoc++;
                }
                // update the right pointer to be ahead of the empty space
                right = i-1;     
         //      increase the wordLoc, and assign empty space to seperate from the next word
                temp[++wordLoc] = ' ';
            }
            // if there are more than one empty space, move the pointer to the next non-empty char in the string of words           
            while(s.charAt(i)== ' ') {
                i--;
                right=i;
            }
        }

        // for the first word in the string, add it in the char array as the last word
        for(int j=left;j<=right;j++) {
           temp[wordLoc] = s.charAt(j);
            wordLoc++;
        }
        // return char array from 0 to wordLoc, and replace "\u0000" to empty space in the converted new string
         String str = new String(temp).substring(0, wordLoc).replace("\u0000"," ");
        return str;
    }
}
