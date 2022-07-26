// use Integer.bitCount to count how many "1" in the binary format of hour and minutes that equals to the turnedOn
// 31 ms (7%) 43.6MB (14%)
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        
        for (int h=0;h<12;h++) {
            for (int m=0;m<60;m++) {
                if ( Integer.bitCount(h) + Integer.bitCount(m)==turnedOn) {
                    ans.add(String.format("%d:%02d",h,m));
                }
            }
        }
                    return ans;
    }
}
// 
