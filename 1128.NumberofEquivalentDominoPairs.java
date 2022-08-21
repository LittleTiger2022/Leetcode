//s1
// 7,s (74%) 60Mb (28%)
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
      int n = dominoes.length;
      int [] dataArray = new int [n];
        for (int i=0;i<n;i++)
        {
            if (dominoes[i][0]<=dominoes[i][1])
                dataArray[i] = dominoes[i][0]*10+dominoes[i][1];
            else
               dataArray[i] = dominoes[i][1]*10+dominoes[i][0]; 
        }
        Arrays.sort(dataArray);
    
        int localCount =0, sumCount =0;
        for (int i=1;i<n;i++) {
            //System.out.println(dataArray[i]);
            if (dataArray[i]==dataArray[i-1])
                localCount++;
            else {
                sumCount +=(localCount+1)*localCount/2;
                localCount=0;
            }
           
            
            //System.out.println("sumCount = " + sumCount + "localCount = " + localCount);
        }
            sumCount +=(localCount+1)*localCount/2;
            return sumCount;
    }
}
// use HashMap
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
       Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;    
    }
}
