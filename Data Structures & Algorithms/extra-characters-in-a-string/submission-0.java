public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return dfs(0, s, dictionary, dp);
    }

    private int dfs(int i, String s, String[] dictionary, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int res = 1 + dfs(i + 1, s, dictionary, dp);
        for (String word : dictionary) {
            if (i + word.length() > s.length()) continue;

            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (s.charAt(i + j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.min(res, dfs(i + word.length(), s, dictionary, dp));
            }
        }
        dp.put(i, res);
        return res;
    }
}