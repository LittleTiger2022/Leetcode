// LC offical solution 2
// 11 ms
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] topoOrder = new int[numCourses];
        
        // create the adjacency list representation of the graph
        for (int i=0;i<prerequisites.length;i++) {
            int dest = prerequisites[i][0];
            int src  = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src,new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);
            
            // Record in-degree of each vertex
            indegree[dest]+=1;
            
        }
        
        // Add at vertices with 0-degree to the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=0; i< numCourses;i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }
        
        int i=0;
        // process until Q is empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topoOrder[i++] = node;
            
            // Reduce the in-degree of each neighour by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor: adjList.get(node)) {
                    indegree[neighbor]--;
                
             // if in-degree of a neighbour becomes 0, add it to the Q
                if (indegree[neighbor]==0) 
                    q.add(neighbor);
            }
        }
        }
      // Check to see if topological sort is possible or not.
         if (i==numCourses) {
             return topoOrder;
         }
        return new int[0];
    }
}
//
