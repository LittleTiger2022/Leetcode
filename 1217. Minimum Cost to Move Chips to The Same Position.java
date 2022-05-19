// essentially, it is to check the parity of number, and take the group with smaller population.
class Solution {
    public int minCostToMoveChips(int[] position) {
        int countEven=0;
        
        for (int i=0;i<position.length;i++) {
            if (position[i] %2==0) countEven++;
        }
     //    System.out.println("even =" + countEven + " odd =" + countOdd);
        return Math.min(position.length-countEven,countEven);
    }
}
