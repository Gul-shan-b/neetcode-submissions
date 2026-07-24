class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for(int i =0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;

        }
        Queue<Integer>queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int index = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[index++] = cur;
            for(int next: graph.get(cur)){
                indegree[next]--;

                if(indegree[next]==0){
                   // res[index++] = next;
                    queue.add(next);
                }
            }
        }
        if(index == numCourses) return res;
        
        return new int[0];

        
    }
}
