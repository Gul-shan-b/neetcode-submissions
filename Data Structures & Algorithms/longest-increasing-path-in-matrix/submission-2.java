/*1. Brute Force — DFS
Logic

Start from every cell and explore all possible increasing paths without storing previously calculated results.

Code
class Solution {
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {

        int count = 1;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i - 1, j));

        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i + 1, j));

        if (j > 0 && matrix[i][j - 1] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i, j - 1));

        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i, j + 1));

        return count;
    }
}

Time: O(4^(m×n)) worst case
Space: O(m×n) recursion stack

2. Normal — DFS + Memoization
Logic

Store the longest increasing path starting from each cell so that the same cell is not calculated repeatedly.

Code
class Solution {
    int m, n;
    int[][] dp;

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

    private int dfs(int[][] matrix, int i, int j) {

        if (dp[i][j] != 0)
            return dp[i][j];

        int count = 1;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i - 1, j));

        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i + 1, j));

        if (j > 0 && matrix[i][j - 1] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i, j - 1));

        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j])
            count = Math.max(count, 1 + dfs(matrix, i, j + 1));

        dp[i][j] = count;
        return count;
    }
}

Time: O(m × n)
Space: O(m × n) */
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