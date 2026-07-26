class Solution {

    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(dfs(0, -1, graph, visited))
            return false;   // cycle exists

        for(boolean v : visited){
            if(!v)
                return false;   // disconnected
        }

        return true;
    }

    private boolean dfs(int node, int parent,
                        List<List<Integer>> graph,
                        boolean[] visited){

        visited[node] = true;

        for(int neighbor : graph.get(node)){

            if(neighbor == parent)
                continue;

            if(visited[neighbor])
                return true;

            if(dfs(neighbor, node, graph, visited))
                return true;
        }

        return false;
    }
}