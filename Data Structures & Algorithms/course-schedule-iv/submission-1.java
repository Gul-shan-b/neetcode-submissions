class Solution {
    private List<Integer>[] adj;

    public List<Boolean> checkIfPrerequisite(int numCourses,
                                             int[][] prerequisites,
                                             int[][] queries) {

        adj = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for(int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);

        List<Boolean> res = new ArrayList<>();

        for(int[] query : queries){
            boolean[] visited = new boolean[numCourses];
            res.add(dfs(query[0], query[1], visited));
        }

        return res;
    }

    private boolean dfs(int node, int target, boolean[] visited){

        if(node == target)
            return true;

        visited[node] = true;

        for(int nei : adj[node]){
            if(!visited[nei]){
                if(dfs(nei, target, visited))
                    return true;
            }
        }

        return false;
    }
}