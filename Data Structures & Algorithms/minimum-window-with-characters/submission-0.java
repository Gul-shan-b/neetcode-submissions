
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(right < s.length()) {
            char ch = s.charAt(right);

            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) {
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            right++;

            while(count == t.length()) {
                int len = right - left;

                if(len < min) {
                    min = len;
                    start = left;
                }

                char leftchar = s.charAt(left);

                if(map.containsKey(leftchar)) {
                    map.put(leftchar, map.get(leftchar) + 1);

                    if(map.get(leftchar) > 0) {
                        count--;
                    }
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" :
               s.substring(start, start + min);
    }
}
