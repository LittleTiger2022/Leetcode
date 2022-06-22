

//
class Solution {
    public int numTrees(int n) {
        if (n<=1)
            return 1;
        int [] c = new int [n+1];
        c[0] = c[1] = 1;
        for ( int i=2;i<=n;++i)
            for (int j=1;j<=i;++j)
                c[i] +=c[j-1]*c[i-j];
        return c[n];
    }
}
