//s1
// 13 ms (31%) 57Mb (15%)
class Solution {
    public List<Integer> lexicalOrder(int n) {
       List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i=0;i<n;i++) {
            list.add(curr);
            if (curr*10<=n) {
                curr*=10;
            } else if (curr %10!=9 && curr+1<=n) {
                curr++;
            } else {
                while ((curr/10)%10==9) {
                    curr /=10;
                }
                curr = curr/10+1;
            }
        }
        return list;
    }
}
// s2
// depth first search
// 6 ms (77%) 57Mb (52%)
class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> res = new ArrayList<>();
        for (int i=1;i<10;++i)
            dfs(i,n,res);
        return res;
    }
    private void dfs(int cur, int n, List<Integer> res) {
        if (cur>n) {
            return;
        } else {
            res.add(cur);
            for (int i=0;i<10;++i) {
                if (10*cur+i>n)
                    return;
                dfs(10*cur+i,n,res);
            }
        }
    }
}
