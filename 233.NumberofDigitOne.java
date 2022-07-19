// s1
//  0 ms 100%
class Solution {
    public int countDigitOne(int n) {
        int counter = 0;
        for (long i=1;i<=n;i*=10) {
            long divider = i*10;
            counter += (n/divider)*i + Math.min(Math.max(n%divider-i+1,0L),i);
        }
        return counter;
    }
}

// s2: resolusive
// 1 ms
class Solution {
    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }
}

// s3
// 1 ms


 /**
 * Calculate occurance on every digit, from
 * least important digit to most important digit
 * number = 1432
 * One's digit: n/10=143 143*1+1
 * Ten's digit: n/100=14 14*10+10
 * Hun's digit: n/1000=1 1*100+100
 * Tho's digit: 1432%1000+1=433
 * Sum all occurance on digits together
 */
class Solution {

public static int countDigitOne(int k) {
    int count = 0, factor = 1, n = k;
    while(n>0){
    	int m = n/10, r = n%10, amount;
    	
    	if(r == 0) amount = 0;
    	else if(r > 1) amount = factor;
    	else amount = k%factor+1;
 
    	count += m*factor + amount;
    	factor *= 10;
    	n = n/10;
    }
    return count;
}
}
