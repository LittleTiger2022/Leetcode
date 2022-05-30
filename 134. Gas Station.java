// my naive solution
// time limit problem
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int [] start = new int [n];
        int count=0;
        
        for (int i=0;i<n;i++) {
            if ( gas[i] - cost[i] >=0 ) 
                start[count++] = i;
        }
        if (count==0) return -1;
        //
        for (int k=0;k<count;k++) {
        int loop=0;
        int i = start[k];
        int curGas = gas[i];
        
        while (loop<n) {
        // System.out.println("k = " + k + " i = " + i + " curGas = " + curGas + " cost[i] = " + cost[i] + " loop = " + loop + " n =  " + n);
            if (curGas- cost[i]>=0 ){
                loop++;
                curGas = curGas - cost[i];
                i++;
                if (i>n-1) i=0;
                curGas = curGas + gas[i];
            }
            else { start[k] =  -1; break;}
        }
         // System.out.println("k = " + k + " count = " + count + " start[k] = " + start[k]);
            if (start[k]>=0) return start[k];
        }
        return -1;
    }
    
    // solution 2
    class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total =0, tank = 0, index =0;
        for (int i=0;i<cost.length;i++) {
            int cur = gas[i] - cost[i];
            tank+=cur;
            
            if (tank<0) {
                index = i+1;
                tank=0;
            }
            total +=cur;
        }
        return total<0? -1: index;
    }
}
}
// 1ms 
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length,start=0, tank=0,sum=0;
        for (int i=0;i<n;i++) {
           tank = tank+gas[i] - cost[i];
        if (tank<0)
        {
            start = i+1;
            sum = sum + tank;
            tank=0;
        }
        }
        return (sum+tank<0) ? -1:start;
       
    }
}
