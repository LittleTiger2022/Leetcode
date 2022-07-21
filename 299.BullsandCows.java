// my naive solution
// 257 ms (5%) 43Mb (16%)
class Solution {
    public String getHint(String secret, String guess) {
        int N = secret.length();
        int [] used = new int [N];
        int [] usedGuess = new int [N];
        int listA = 0, listB=0;
        
        for (int i=0;i<N;i++)  {
            used[i]=0;
            usedGuess[i] = 0;
        }
        
        // first: find listA
        for (int i=0;i<N;i++) {
            if (guess.charAt(i)==secret.charAt(i)) {
                used[i]=1;
                usedGuess[i]=1;
                listA++;
            }
        }
        
        for (int i=0;i<N;i++) {
            if ( guess.charAt(i)!=secret.charAt(i)) {
                for (int j=0; j<N;j++) {
                    //System.out.println(Arrays.toString(used));
                    if (usedGuess[i]==0 & used[j]==0 & guess.charAt(i)==secret.charAt(j)) {
                        used[j]=1;
                        usedGuess[i]=1;
                        listB++;
                    }
                }
            }
        }
        
        String res = listA+"A"+listB+"B";
        return res;
        
    }
}
// a smart method
// 10 ms (55%) 42 Mb (90%)
class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0, cows=0;
        int [] numbers = new int[10];
        
        for (int i=0;i<secret.length();i++) {
            if (secret.charAt(i)==guess.charAt(i))
                bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++<0)
                    cows++;
                if (numbers[guess.charAt(i)-'0']-->0)
                    cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
