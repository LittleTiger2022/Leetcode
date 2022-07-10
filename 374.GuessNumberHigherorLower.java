// s1
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low=1,high = n,ans=0;
        while (low<=high) {
            int mid = (low+high) >>>1;
            int test = guess(mid);
            if (test==0)
            {
                ans = mid;
                break;
            }
            else if (test<0)
                high = mid-1;
            else
                low = mid+1;
        }
        return ans;
    }
}
