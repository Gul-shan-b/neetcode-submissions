
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Convert List to HashSet for O(1) lookups (fixes TLE)
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            String word = queue.poll();

            if (word == null) {
                level++;
                if (!queue.isEmpty())
                    queue.add(null);
                continue;
            }

            if (word.equals(endWord)) return level;

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String nextWord = new String(chars);

                    // 2. Use dict.contains() instead of wordList.contains()
                    if (dict.contains(nextWord) && !visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}