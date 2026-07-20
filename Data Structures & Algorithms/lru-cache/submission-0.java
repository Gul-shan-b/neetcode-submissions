class LRUCache {

    class ListNode {

        int key;
        int value;

        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, ListNode> map;

    int capacity;

    ListNode head;

    ListNode tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new ListNode(0,0);

        tail = new ListNode(0,0);

        head.next = tail;

        tail.prev = head;
    }

    public int get(int key) {

        if(!map.containsKey(key)) {

            return -1;
        }

        ListNode node = map.get(key);

        deleteNode(node);

        insertAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {

            ListNode node = map.get(key);

            node.value = value;

            deleteNode(node);

            insertAfterHead(node);
        }

        else {

            if(map.size() == capacity) {

                ListNode node = tail.prev;

                map.remove(node.key);

                deleteNode(node);
            }

            ListNode node = new ListNode(key,value);

            map.put(key,node);

            insertAfterHead(node);
        }
    }

    private void deleteNode(ListNode node) {

        node.prev.next = node.next;

        node.next.prev = node.prev;
    }

    private void insertAfterHead(ListNode node) {

        node.next = head.next;

        node.prev = head;

        head.next.prev = node;

        head.next = node;
    }
}