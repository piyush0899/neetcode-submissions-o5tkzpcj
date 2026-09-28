
class LFUCache {

    // key -> node
    HashMap<Integer, Node> keyNode;

    // frequency -> doubly linked list
    HashMap<Integer, DoublyLinkedList> freqList;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        keyNode = new HashMap<>();
        freqList = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        // Key doesn't exist
        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Capacity is zero
        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyNode.containsKey(key)) {

            Node node = keyNode.get(key);

            // Update value
            node.value = value;

            // put() also increases frequency
            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (keyNode.size() == capacity) {

            DoublyLinkedList list = freqList.get(minFreq);

            // Remove least recently used node
            Node removedNode = list.removeLast();

            keyNode.remove(removedNode.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Add to hashmap
        keyNode.put(key, newNode);

        // New key has frequency 1
        minFreq = 1;

        // Get/create frequency 1 list
        if (!freqList.containsKey(1)) {

            freqList.put(1, new DoublyLinkedList());
        }

        // Add new node to front
        freqList.get(1).addFirst(newNode);
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        // Remove from old frequency list
        DoublyLinkedList oldList = freqList.get(oldFreq);

        oldList.remove(node);

        // If old frequency was minimum
        // and its list became empty
        if (oldFreq == minFreq && oldList.isEmpty()) {

            minFreq++;
        }

        // Increase frequency
        node.freq++;

        int newFreq = node.freq;

        // Create new frequency list if required
        if (!freqList.containsKey(newFreq)) {

            freqList.put(newFreq, new DoublyLinkedList());
        }

        // Add node at front because it is recently used
        freqList.get(newFreq).addFirst(node);
    }
}


class Node {

    int key;
    int value;
    int freq;

    Node prev;
    Node next;

    Node(int key, int value) {

        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}


class DoublyLinkedList {

    Node head;
    Node tail;

    DoublyLinkedList() {

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node removeLast() {

        if (head.next == tail) {
            return null;
        }

        Node node = tail.prev;

        remove(node);

        return node;
    }

    boolean isEmpty() {

        return head.next == tail;
    }
}