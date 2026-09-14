

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        // New element q2 mein daalo
        q2.offer(x);

        // q1 ke saare elements q2 mein transfer karo
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // q1 aur q2 swap karo
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {

        return q1.poll();
    }

    public int top() {

        return q1.peek();
    }

    public boolean empty() {

        return q1.isEmpty();
    }
}