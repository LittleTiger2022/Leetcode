// my naive solution (few places for corner cases)
// 1ms O(n) 100% 52Mb 18.6%
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0)
            return true;
        boolean res=false;
        int nPlace = flowerbed.length;
        //System.out.println(nPlace +  "  "  + flowerbed[0]);
        if (nPlace==1 && flowerbed[0]==1)
            return false;
        
        if (nPlace==1 && flowerbed[0]==0)
            return true;
        
        
        int availLoc = 0;
        if (flowerbed[0] ==0 && flowerbed[1]==0) {
            availLoc++;
            flowerbed[0]=1;   
        }
        if (flowerbed[nPlace-2] ==0 && flowerbed[nPlace-1]==0) {
            flowerbed[nPlace-1]=1;
            availLoc++;
        }
        if (availLoc>=n) 
                res= true;
        
        if (nPlace>=3) {
        for (int i=2;i<nPlace-2;i++) {
            if (flowerbed[i-1]== 0 && flowerbed[i]==0 && flowerbed[i+1]==0)
            {  availLoc++;
             flowerbed[i]=1; 
             }
            if (availLoc>=n) 
            { res= true;
             break;}
    }
        }
        return res;
    }
}
// solution 2: wrap corner cases inside loop
// 1 ms 100%; 52.9Mb
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i=0;i<flowerbed.length;i++) {
            if (flowerbed[i]==0) {
                boolean emptyLeftPlot = (i==0) || (flowerbed[i-1]==0);
                boolean emptyRightPlot = (i==flowerbed.length-1) || (flowerbed[i+1]==0);
            
            if (emptyLeftPlot && emptyRightPlot) {
                flowerbed[i]=1;
                count++;
                if (count>=n)
                  return true;
            }
        }
    return count>=n;
    }
}
//
