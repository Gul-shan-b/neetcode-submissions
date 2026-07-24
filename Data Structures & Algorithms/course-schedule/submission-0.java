class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){
            
            int cur = queue.poll();
            count++;

            for(int next:graph.get(cur)){
                indegree[next]--;

                if(indegree[next]== 0) queue.add(next);
            }

        }
        return count==numCourses;


        
    }
}
