class MyCircularQueue {

    int[] queue;

    int front;
    int rear;

    int size;
    int capacity;

    public MyCircularQueue(int k) {

        queue = new int[k];

        capacity = k;

        front = 0;
        rear = 0;

        size = 0;
    }

    public boolean enQueue(int value) {

        // Queue full hai
        if (isFull()) {
            return false;
        }

        // Value ko rear position par insert karo
        queue[rear] = value;

        // Rear ko circularly move karo
        rear = (rear + 1) % capacity;

        size++;

        return true;
    }

    public boolean deQueue() {

        // Queue empty hai
        if (isEmpty()) {
            return false;
        }

        // Front ko circularly move karo
        front = (front + 1) % capacity;

        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        // rear next insertion position ko point karta hai
        // Isliye actual last element rear - 1 par hai
        int lastIndex = (rear - 1 + capacity) % capacity;

        return queue[lastIndex];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }
}