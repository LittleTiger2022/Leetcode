// my naive solution
// 13 ms (15%) 48 Mb( 65%)
// time O(nlogn)
class Solution {
    public int[] countBits(int n) {
        int [] res = new int [n+1];
        for (int i=0;i<=n;i++) {
           //  res[i] = 0;
        String temp = Integer.toBinaryString(i);
       //     System.out.println(temp);
            for (int j=0;j<temp.length();j++)
                if (temp.charAt(j)=='1')
                    res[i]++;
            
        }
        return res;
    }
}

// 2ms (86%)
class Solution {
    public int[] countBits(int n) {
        int [] res = new int [n+1];
        for (int i=1;i<=n;i++) {
          res[i] = res[i & (i-1)] +1;
            
        }
        return res;
    }
}

// 4ms
class Solution {
    public int[] countBits(int n) {
        int [] res = new int [n+1];
        for (int i=1;i<=n;i++) {
          res[i] = Integer.bitCount(i);
            
        }
        return res;
    }
}

// 3ms
class Solution {
    public int[] countBits(int n) {
    
    int[] f = new int[n + 1];
    for (int i=1; i<=n; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
    }
}
