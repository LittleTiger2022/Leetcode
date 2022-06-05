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
    
// 38 ms, easy to understand solution
    class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     //first collect all the courses that need to take from prerequisite

int[] needsForDegree = new int[numCourses];
for(int i = 0; i < prerequisites.length; i++){
	needsForDegree[prerequisites[i][0]]++; //count the number of prerequisites for each course
	//for example: [1, 0], [1, 2], then course 1 needs 2 prerequisites
}

Queue<Integer> availableClasses = new LinkedList<Integer>();
//now search for any class that doesn't need prequisite class among all classes
for(int i = 0; i < needsForDegree.length; i++){
	if(needsForDegree[i] == 0){
		availableClasses.offer(i);
	}
}
while(!availableClasses.isEmpty()){
	//select an takable class
	int startClass = availableClasses.poll();
	//check if it satisfies any classes' prereq
	for(int i = 0; i < prerequisites.length; i++){
		if(prerequisites[i][1] == startClass){
			//then reduce the num of prereq needed for this class
			needsForDegree[prerequisites[i][0]]--;
			//now check if this class can be completed
			if(needsForDegree[prerequisites[i][0]] == 0){
				//puts it into the available class
				availableClasses.offer(prerequisites[i][0]);
			}
		}
	}
}

//now check if all the prerequsites are reduced to 0 for every class
for(int count : needsForDegree){
	if(count != 0)
		return false; 
}
 return true; 
 
    }
}
