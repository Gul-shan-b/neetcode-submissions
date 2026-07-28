class Solution {

    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    public double dfs(String src, String dest,
                      HashSet<String> visited,
                      double product) {

        if (src.equals(dest))
            return product;

        visited.add(src);

        for (String neighbour : graph.get(src).keySet()) {

            if (!visited.contains(neighbour)) {

                double ans = dfs(
                        neighbour,
                        dest,
                        visited,
                        product * graph.get(src).get(neighbour));

                if (ans != -1.0)
                    return ans;
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, value);
            graph.get(v).put(u, 1.0 / value);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            }
            else if (src.equals(dest)) {
                ans[i] = 1.0;
            }
            else {
                HashSet<String> visited = new HashSet<>();
                ans[i] = dfs(src, dest, visited, 1.0);
            }
        }

        return ans;
    }
}