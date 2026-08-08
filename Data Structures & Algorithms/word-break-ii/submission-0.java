class Solution {

    HashSet<String> set = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        set.addAll(wordDict);

        return solve(s);
    }

    private List<String> solve(String s) {

        // Base case
        if (s.isEmpty()) {
            return Arrays.asList("");
        }

        List<String> result = new ArrayList<>();

        // Try every possible prefix
        for (int i = 1; i <= s.length(); i++) {

            String currWord = s.substring(0, i);

            // If prefix exists in dictionary
            if (set.contains(currWord)) {

                String remainWord = s.substring(i);

                // Solve remaining string recursively
                List<String> remainResult = solve(remainWord);

                // Combine current word with remaining answers
                for (String word : remainResult) {

                    String sentence = currWord +
                            (word.isEmpty() ? "" : " ") +
                            word;

                    result.add(sentence);
                }
            }
        }

        return result;
    }
}