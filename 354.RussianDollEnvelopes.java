// s1
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length, len = 1;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len++] = envelopes[i][1];
            } else {
                int id = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
                if (id < 0) id = -(id + 1);
                dp[id] = envelopes[i][1];
            }
        }
        return len;
    }
}
//

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // corner case
        if (envelopes.length < 2) {
            return envelopes.length;
        }

        // normal case
        // <w, h>
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < e[1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = e[1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
