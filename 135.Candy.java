// s1
// O(n) 6 ms (31.85%); O(n)  52 Mb (17%)
// use two arrays 
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, sum = 0;
        int [] left = new int [n], right = new int [n];
        left[0] = 1;
        right[n-1] = 1;
        
        for (int i=1;i<n;i++) {
            if (ratings[i] > ratings[i-1])
                left[i] = left[i-1];
            left[i] +=1;
            
            if (ratings[n-i-1]> ratings[n-i])
                right[n-i-1] = right[n-i];
            right[n-i-1]+=1;
            
        }
        
        for ( int i=0;i<n; i++) 
            sum +=Math.max(left[i], right[i]);
        return sum;
    }
}

//
