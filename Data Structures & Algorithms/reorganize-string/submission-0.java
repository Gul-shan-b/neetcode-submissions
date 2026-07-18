class Solution {
    public String reorganizeString(String s) {

        // Store frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        for (char curChar : s.toCharArray()) {
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // Max Heap based on frequency
        Queue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        while (maxHeap.size() > 1) {

            // Most frequent character
            Character firstChar = maxHeap.poll();
            sb.append(firstChar);
            map.put(firstChar, map.get(firstChar) - 1);

            // Second most frequent character
            Character secondChar = maxHeap.poll();
            sb.append(secondChar);
            map.put(secondChar, map.get(secondChar) - 1);

            // Add them back if frequency is still greater than 0
            if (map.get(firstChar) > 0) {
                maxHeap.add(firstChar);
            }

            if (map.get(secondChar) > 0) {
                maxHeap.add(secondChar);
            }
        }

        // If one character remains
        if (!maxHeap.isEmpty()) {

            if (map.get(maxHeap.peek()) > 1) {
                return "";
            }

            sb.append(maxHeap.peek());
        }

        return sb.toString();
    }
}