// my solution
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int [] elements = new int [n];
        int totalNumber = 1, block1=0, assigned=0, remindK = 0,restN=n;
        for (int i=1;i<=n;i++) {
            totalNumber*=i;
            elements[i-1] = i;
        }
       //  System.out.println(Arrays.toString(elements));
        // it is easier to get the first value
        block1 = totalNumber/n;
        assigned = (int) Math.ceil( (double) k/block1);
        remindK = k - block1*(assigned-1);
        sb.append( assigned );
        restN --;
        elements[assigned-1]= 0; // replace the used number as 0
        for (int i=assigned-1;i<n-1;i++) {
            elements[i] = elements[i+1];
        }
         elements[n-1] = 0;
        
          System.out.println("sb = " + sb + " assigned = " + assigned );
        // continue searching for the rest n-1 numbers
        System.out.println(Arrays.toString(elements));
         System.out.println("restN = " + restN);
        while (restN>0) {
            totalNumber=1;
            for (int i=1;i<=restN;i++) {
            totalNumber*=i;
        }
            if (totalNumber==1) {
                assigned = elements[0];
                sb.append( assigned );
                break;
            }
            block1 =totalNumber/restN;
             System.out.println("totalNumber = " + totalNumber + " block1 = " + block1  + " remindK = " + remindK);
             System.out.println("element = " + Arrays.toString(elements));
            int newID = (int) Math.ceil( (double) remindK/block1)-1;
            System.out.println("newID =" + newID);
            assigned = elements[newID];
            remindK = remindK - block1*(assigned-1);
            System.out.println("assigned = " + assigned + " restN = " + restN + " newID = " + newID);
            sb.append( assigned );
            System.out.println(sb);
          
             System.out.println("assigned = " + assigned + " restN = " + restN);
             System.out.println("element = " + Arrays.toString(elements));
            elements[newID]= 0; // replace the used number as 0
         for (int i=newID;i<restN;i++) {
            elements[i] = elements[i+1];
        }
        elements[restN-1] = 0;
              restN--;
             System.out.println("element = " + Arrays.toString(elements)+ " restN = " + restN);
        }
        
        
        String ans = sb.toString();
        return ans;
    }
}

// Simplified version (do everything in one loop)
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int [] elements = new int [n];
        int totalNumber = 1, block1=0, assigned=0, remindK = k,restN=n;
       
        for (int i=1;i<=restN;i++) {
                elements[i-1] = i;
            }
        while (restN>0) {
            totalNumber=1;
            for (int i=1;i<=restN;i++) {
            totalNumber*=i;
            }
            if (totalNumber==1) {
                assigned = elements[0];
                sb.append( assigned );
                break;
            }
            block1 =totalNumber/restN;
             System.out.println("totalNumber = " + totalNumber + " block1 = " + block1  + " remindK = " + remindK);
             System.out.println("element = " + Arrays.toString(elements));
            int newID = (int) Math.ceil( (double) remindK/block1)-1;
            System.out.println("newID =" + newID);
            assigned = elements[newID];
            remindK = remindK - block1*newID;
            System.out.println("assigned = " + assigned + " restN = " + restN + " newID = " + newID + " remindK = "+ remindK);
            sb.append( assigned );
            System.out.println(sb);
          
             System.out.println("assigned = " + assigned + " restN = " + restN);
             System.out.println("element = " + Arrays.toString(elements));
            elements[newID]= 0; // replace the used number as 0
         for (int i=newID;i<restN-1;i++) {
            elements[i] = elements[i+1];
        }
        elements[restN-1] = 0;
              restN--;
             System.out.println("element = " + Arrays.toString(elements)+ " restN = " + restN);
        }
        
        
        String ans = sb.toString();
        return ans;
    }
}

// a little bit more cleaned version
// 3ms
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int [] elements = new int [n];
        int totalNumber = 1, block1=0, assigned=0, remindK = k,restN=n;
       
        for (int i=1;i<=restN;i++) {
                elements[i-1] = i;
            }
        while (restN>0) {
            totalNumber=1;
            for (int i=1;i<=restN;i++) {
            totalNumber*=i;
            }
            if (totalNumber==1) {
                assigned = elements[0];
                sb.append( assigned );
                break;
            }
            block1 =totalNumber/restN;
          
            int newID = (int) Math.ceil( (double) remindK/block1)-1;
            assigned = elements[newID];
            remindK = remindK - block1*newID;
            sb.append( assigned );
          
            elements[newID]= 0; // replace the used number as 0
         for (int i=newID;i<restN-1;i++) {
            elements[i] = elements[i+1];
        }
        elements[restN-1] = 0;
              restN--;
        }
        
        String ans = sb.toString();
        return ans;
    }
}
