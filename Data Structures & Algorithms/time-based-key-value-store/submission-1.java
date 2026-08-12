class TimeMap {

    private Map<String, List<Pair>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new ArrayList<>());
        }

        keyStore.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if (!keyStore.containsKey(key)) {
            return "";
        }

        List<Pair> list = keyStore.get(key);

        int left = 0;
        int right = list.size() - 1;
        String ans = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).time <= timestamp) {
                ans = list.get(mid).value;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    class Pair {
        int time;
        String value;

        Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }
}