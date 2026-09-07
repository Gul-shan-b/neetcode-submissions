public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        int[] dist = new int[ROWS * COLS];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] inQueue = new boolean[ROWS * COLS];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        inQueue[0] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;

            int r = u / COLS, c = u % COLS;

            for (int[] dir : directions) {
                int newR = r + dir[0], newC = c + dir[1];
                if (newR >= 0 && newC >= 0 && newR < ROWS && newC < COLS) {
                    int v = newR * COLS + newC;
                    int weight = Math.abs(heights[r][c] - heights[newR][newC]);
                    int newDist = Math.max(dist[u], weight);
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        if (!inQueue[v]) {
                            queue.offer(v);
                            inQueue[v] = true;
                        }
                    }
                }
            }
        }

        return dist[ROWS * COLS - 1];
    }
}