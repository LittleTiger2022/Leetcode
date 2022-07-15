// s1
// 51 ms (46%), 56 Mb (9%)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<int []>  heights = new ArrayList<>();
        for ( int [] b: buildings) {
            heights.add(new int[]  { b[0],-b[2] });
            heights.add(new int [] { b[1],b[2] });
        }
        Collections.sort(heights,(a,b) -> (a[0]==b[0])? a[1]-b[1]:a[0]-b[0]);
        TreeMap<Integer,Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight=0;
        // List<int[]> skyLine = new LinkedList<>();
        List<List<Integer>> skyLine = new ArrayList<>();
        for (int [] h: heights) {
            if (h[1]<0) {
                heightMap.put(-h[1],heightMap.getOrDefault(-h[1],0)+1);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt==1) {
                    heightMap.remove(h[1]);
            } else {
                heightMap.put(h[1], cnt-1);
            }
        }
        int currHeight = heightMap.firstKey();
        if (prevHeight!=currHeight) {
           // skyLine.add( new int[] {h[0],currHeight});
            int [] ints = {h[0],currHeight};
            List<Integer> tempList = Arrays.stream(ints).boxed().collect(Collectors.toList());
            skyLine.add(tempList);
            prevHeight = currHeight;
        }
    }
    return skyLine;
        
    }
}
// s2: use PriortyQueue
// 450 ms
class Solution {
public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList<>();
    List<int[]> list = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    for(int[] build: buildings){
        int start = build[0], end = build[1], height = build[2];
        list.add(new int[] {start, -height});
        list.add(new int[] {end, height});
    }
    
    Collections.sort(list, (a,b) -> {
        if(a[0] != b[0])
            return a[0] - b[0];
        else
            return a[1]- b[1];
        });
    
    int currHt = 0;
    pq.offer(0);
    
    for(int[] temp : list){
        int x = temp[0], ht = temp[1];
        if(ht < 0)
            pq.offer(-ht);
        else
            pq.remove(ht);
        
        if(currHt != pq.peek()){
            List<Integer> li = new ArrayList<>();
            li.add(x);
            li.add(pq.peek());
            
            result.add(li);
            currHt = pq.peek();
        }
    }
    
    return result;
}
}
