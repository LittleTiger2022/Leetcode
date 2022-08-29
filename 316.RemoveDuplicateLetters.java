//s1
// 
class Solution {
    public String removeDuplicateLetters(String s) {
      final int N = 26;
        int [] count = new int [N];
        boolean [] inQueue = new boolean [N];
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i=0;i<s.length();i++) {
            count[s.charAt(i)-'a']++;
        }
        
        for (int i=0;i<s.length();i++) {
            int idx = (int) (s.charAt(i)-'a');
            count[idx]--;
            if (inQueue[idx]) {
                continue;
            }
            while(!dq.isEmpty() && dq.peekLast()>idx && count[dq.peekLast()]>0) {
                inQueue[dq.pollLast()] = false;
            }
            inQueue[idx]=true;
            dq.offerLast(idx);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append((char) (dq.pollFirst()+'a'));
        }
        return sb.toString();
    }
}
//
