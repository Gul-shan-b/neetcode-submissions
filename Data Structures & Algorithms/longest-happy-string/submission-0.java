class Solution {

    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));


        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair first = pq.poll();
            int len = ans.length();

            if (len >= 2 &&
                ans.charAt(len - 1) == first.ch &&
                ans.charAt(len - 2) == first.ch) {

                if (pq.isEmpty()) {
                    break;
                }

                Pair second = pq.poll();

                ans.append(second.ch);   // Correct
                second.count--;

                if (second.count > 0) {
                    pq.add(second);
                }

                pq.add(first);

            } else {

                ans.append(first.ch);    // Correct
                first.count--;

                if (first.count > 0) {
                    pq.add(first);
                }
            }
        }

        return ans.toString();
    }
}