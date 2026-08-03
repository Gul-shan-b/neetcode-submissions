class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, char[]> map = Map.of(
        '2', new char[]{'a', 'b', 'c'},
        '3', new char[]{'d', 'e', 'f'},
        '4', new char[]{'g', 'h', 'i'},
        '5', new char[]{'j', 'k', 'l'},
        '6', new char[]{'m', 'n', 'o'},
        '7', new char[]{'p', 'q', 'r', 's'},
        '8', new char[]{'t', 'u', 'v'},
        '9', new char[]{'w', 'x', 'y', 'z'}
    );

    public List<String> letterCombinations(String digits) {
        backTrack(0, digits, new StringBuilder());
        return res;
    }

    private void backTrack(int i, String digits, StringBuilder sb) {
        if (i == digits.length() && sb.length() != 0) {
            res.add(sb.toString());
            return;
        }

        if (digits.length() == 0) {
            return;
        }

        char[] chars = map.get(digits.charAt(i));
        for (int j = 0; j < chars.length; j++) {
            sb.append(chars[j]);
            backTrack(i + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
