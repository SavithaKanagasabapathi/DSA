class LRUCache {
    //TC-O(1) for all and SC-O(C), c is capacity
    //Doubly Linked List
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);//dummy head and tail
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {//latest access
            Node node = map.get(key);
            remove(node);//remove from current position
            insert(node);//add after head
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {//to update, remove current node and insert after head
            remove(map.get(key));
        }
        if (map.size() == capacity) {//If map capacity == capacity, remove LRU tail.prev
            remove(tail.prev);
        }
        insert(new Node(key, value));//insert after head
    }

    public void remove(Node node) {//remove node
        map.remove(node.key);
        node.prev.next = node.next;//Head-Node-Tail, to remove Node, imagine pointers
        node.next.prev = node.prev;
    }

    public void insert(Node node) {//insert after head
        map.put(node.key, node);
        //Head-Node1-Tail, Insert node after head like Head-Node-Node1-Tail
        Node headNext = head.next;//store head next
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }
}

//TC-O(1) for all and SC-O(C), c is capacity
//Linked HashMap
//true = access-order (LRU), false = insertion-order
//0.75f: The load factor (standard for HashMaps).
// Think of the cache like a theater with 100 seats.
// If the load factor is 0.75, as soon as the 75th person sits down, 
// the theater management says, "We're getting too crowded! Let's build a bigger theater."
// In Java, it typically doubles the number of buckets when this threshold is hit.
// Formula: Threshold = Capacity * Load Factor
// class LRUCache extends LinkedHashMap<Integer, Integer> {
//     private int capacity;

//     public LRUCache(int capacity) {
//         super(capacity, 0.75f, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         // Return true when the map exceeds capacity to trigger automatic deletion
//         return size() > capacity;//here > and not ==, as it quickly deletes if size
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */