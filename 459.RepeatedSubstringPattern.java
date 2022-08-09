// s1
// KMP algorithm O(n) in T&S
// 12 ms (91%) 49Mb (64%)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }
    public boolean kmp(String pattern) {
        int n = pattern.length();
        int [] fail = new int [n];
        Arrays.fill(fail,-1);
        for (int i=1;i<n;i++) {
            int j = fail[i-1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
            j = fail[j];
        }
        if (pattern.charAt(j + 1) == pattern.charAt(i)) {
            fail[i] = j + 1;
        }
    }
    return fail[n-1]!=-1 && n%(n-fail[n-1]-1)==0;
   }
}
// concise KMP method
// 8 ms (97%) 51Mb 49%
class Solution {
public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    int[] kmp = new int[n];
    char[] arr = s.toCharArray();
    for(int i = 1; i < n; i++){
        int index = kmp[i - 1];
        while(index > 0 && arr[i] != arr[index]){
            index = kmp[index - 1];
        }
        if(arr[i] == arr[index]){
            index++;
        }
        kmp[i] = index;
    }
    int t= kmp[n - 1];
    return t > 0 && n % (n - t) == 0;
}
}

