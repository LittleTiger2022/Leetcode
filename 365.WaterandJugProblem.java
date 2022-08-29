// s1
// use gcd (Bezout's identity)
 class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        
        // boolean res = false;
        if ((targetCapacity>jug1Capacity+jug2Capacity) || (jug1Capacity%2==0 && jug2Capacity%2==0 &&  targetCapacity%2!=0))
            return false;
       if (jug1Capacity==targetCapacity ||jug2Capacity==targetCapacity || jug1Capacity+jug2Capacity==targetCapacity  )
           return true;
        
        return targetCapacity%gcd(jug1Capacity,jug2Capacity)==0;
    }
    public int gcd(int a, int b) {
        if (a==0)
            return b;
        return gcd(b%a,a);
    }
}


