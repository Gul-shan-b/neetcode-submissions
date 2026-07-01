class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> charset = new HashSet<>();
        int max_len = 0;
        int left = 0;

        for (int r = 0; r < n; r++) {

            while (charset.contains(s.charAt(r))) {
                charset.remove(s.charAt(left));
                left++;
            }

            charset.add(s.charAt(r));

            max_len = Math.max(max_len, r - left + 1);
        }

        return max_len;
    }
}