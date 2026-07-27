class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n+1];
            if (dfs(u,v, graph, visited)){
                return edge;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
       
    }
    private boolean dfs(int current, int destination, List<List<Integer>> graph,
    boolean[] visited){
        if(current == destination){
            return true;
        }
        visited[current] = true;
        for(int neighbor : graph.get(current)){
            if(!visited[neighbor]){
                if(dfs(neighbor, destination, graph, visited)){
                    return true;
                }
            }
        }
        return false;

    }
}
