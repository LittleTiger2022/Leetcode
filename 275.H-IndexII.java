// binary search 
// 0 ms 100%; 53Mb 23%
class Solution {
    public int hIndex(int[] citations) {
      //  if (citations.length==1)
       //     return 1;
        
      int nPaper = citations.length;
      int left = 0;
        int right = nPaper-1;
       int res =Math.min(citations[0],nPaper);
        
      while (left<right) {
          
          int mid = (left+right)/2;
          
          if (citations[mid]>=nPaper-mid)
              right = mid;
          else
              left = mid+1;
      }
        if (citations[left]>= nPaper - left)
            res = nPaper - left;
        return res;
    }
}
// solution 2:
// 0 ms 100%, 23%
class Solution {
    public int hIndex(int[] citations) {
    int result = 0;
    int nPaper = citations.length;    
        while (result<nPaper) {
            if (citations[nPaper -1 - result]<result+1)
                return result;
            result +=1;
        }
        return result;
    }
}

