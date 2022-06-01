// the easiest one
// 1ms
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0,count=0;
        for (int i=columnTitle.length()-1;i>=0;i--) {
            int cur = columnTitle.charAt(i)-'A' +1;
            if (count==0)
            ans=cur;
            if (count>0) {
                for (int j=0;j<count;j++)
                    cur *=26;
            ans +=cur;
            }
            count++;
        }
        return ans;
    }
}

// the most shortest version
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        for (int i=0;i<columnTitle.length();i++) {
            ans = ans*26 + columnTitle.charAt(i)-'A'+1;
        }
        return ans;
    }
}
