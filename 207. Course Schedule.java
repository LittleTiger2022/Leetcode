// 40 ms 8%
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int [numCourses];
        for ( int [] pre: prerequisites) {
            indegree[pre[0]]++;
        }
        
        Set <Integer> zeroDegree = new HashSet();
        for ( int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                zeroDegree.add(i);
            }
        }
        
        if (zeroDegree.isEmpty()) {
            return false;
        }
        
        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            zeroDegree.remove(course);
            for ( int [] pre:prerequisites ) {
                if (course==pre[1]) {
                    indegree[pre[0]]--;
                    if (indegree[pre[0]]==0) {
                        zeroDegree.add(pre[0]);
                    }
                }
            }
        }
        for (int num: indegree) {
            if (num!=0)
                return false;
        }
        return true;
    }
// solution 2: from 山景城一姐 https://www.youtube.com/watch?v=fskPWs3Nuhc
// 11 ms 36%
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int [numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for ( int [] pre: prerequisites) {
            indegree[pre[0]]++;
            if (graph.containsKey(pre[1])) {
                graph.get(pre[1]).add(pre[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                graph.put(pre[1],list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        
        for ( int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> toTake = graph.get(cur);
            for (int i=0; toTake!=null && i<toTake.size();i++ ) 
            {
                  indegree[toTake.get(i)]--;
                  if (indegree[toTake.get(i)]==0)    queue.add(toTake.get(i));
            }
                }
         
        
        for (int num: indegree) {
            if (num!=0)
                return false;
        }
        return true;
    }
}
\\ solution 3
    \\ 12 ms
    class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] preCount = new int[numCourses];
        int finishable =0;
        
        Map<Integer,List<Integer>> m = new HashMap<>();
        
        for ( int[] p:prerequisites ) {
            List<Integer> c = m.getOrDefault(p[1], new ArrayList<>());
            c.add(p[0]);
            m.put(p[1],c);
            ++preCount[p[0]];
        }
        
        Queue <Integer> q = new LinkedList<>();
        for (int i=0;i<numCourses;i++) 
            if (preCount[i]==0)
                q.offer(i);
        
            while (!q.isEmpty()) {
                int cur = q.poll();
                ++finishable;
            for (int n: m.getOrDefault(cur, new ArrayList<>())) {
                --preCount[n];
                if (preCount[n]==0)
                    q.offer(n);
            }
                
            }
        return finishable == numCourses;
    }
}
