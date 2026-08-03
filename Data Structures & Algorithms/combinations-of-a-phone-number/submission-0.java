class Solution {

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String cur = new String();

        solve(0, digits,cur, map);

        return result;
    }

    private void solve(int index, String digits,String cur,Map<Character, String> map) {
        if (index == digits.length()) {
            result.add(cur);
            return;
        }
        char ch = digits.charAt(index);
        String str = map.get(ch);
        for (int i = 0; i < str.length(); i++) {
            solve(index + 1, digits, cur + str.charAt(i), map);
        }
    }
}
