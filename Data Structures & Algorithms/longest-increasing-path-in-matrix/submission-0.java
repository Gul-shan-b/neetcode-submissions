class Solution {

    int[][] dp;
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int i, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int count = 1;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            count = Math.max(count, 1 + dfs(matrix, i - 1, j));
        }

        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            count = Math.max(count, 1 + dfs(matrix, i + 1, j));
        }

        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            count = Math.max(count, 1 + dfs(matrix, i, j - 1));
        }

        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            count = Math.max(count, 1 + dfs(matrix, i, j + 1));
        }

        dp[i][j] = count;

        return count;
    }
}