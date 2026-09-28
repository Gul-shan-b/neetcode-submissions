public class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int N = nums.length;
        if (N == 1) return true;
        for (int num : nums) {
            if (num == 1) return false;
        }

        int MAX = Arrays.stream(nums).max().getAsInt();
        int[] sieve = new int[MAX + 1];
        int p = 2;
        while (p * p <= MAX) {
            if (sieve[p] == 0) {
                for (int composite = p * p; composite <= MAX; composite += p) {
                    sieve[composite] = p;
                }
            }
            p++;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            if (sieve[num] == 0) { // num is prime
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(N + num);
                adj.computeIfAbsent(N + num, k -> new ArrayList<>()).add(i);
                continue;
            }

            while (num > 1) {
                int prime = (sieve[num] != 0) ? sieve[num] : num;
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(N + prime);
                adj.computeIfAbsent(N + prime, k -> new ArrayList<>()).add(i);
                while (num % prime == 0) {
                    num /= prime;
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }
}