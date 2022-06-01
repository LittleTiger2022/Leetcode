//
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        int sign = numerator >0 ^ denominator>0?  -1 : 1;
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        long cur = dividend/divisor;
        long reminder = dividend % divisor;
        StringBuilder ans = new StringBuilder ();
        if (reminder==0) {
            ans.append(cur*sign);
            return ans.toString();
        }
        ans.append((sign<0? "-":"")).append(cur).append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (reminder>0) {
            if (map.containsKey(reminder)) {
                //ans.append("(").append(map.get(reminder)).append(")");
                ans.insert(map.get(reminder),"(");
                ans.append(")");
                break;
            }
          map.put(reminder,ans.length());
            reminder *=10;
            cur = reminder/ divisor;
            ans.append(cur);
            reminder %=divisor;
        }
        return ans.toString();
    }
}
