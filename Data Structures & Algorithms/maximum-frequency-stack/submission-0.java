

class FreqStack {

    HashMap<Integer, Integer> freq;

    HashMap<Integer, Stack<Integer>> group;

    int maxFreq;

    public FreqStack() {

        freq = new HashMap<>();

        group = new HashMap<>();

        maxFreq = 0;
    }

    public void push(int val) {

        // Increase frequency of val
        int newFreq = freq.getOrDefault(val, 0) + 1;

        freq.put(val, newFreq);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, newFreq);

        // If stack for this frequency doesn't exist
        if (!group.containsKey(newFreq)) {
            group.put(newFreq, new Stack<>());
        }

        // Push val into stack of its new frequency
        group.get(newFreq).push(val);
    }

    public int pop() {

        // Get stack containing most frequent elements
        Stack<Integer> stack = group.get(maxFreq);

        // Remove the most recently pushed element
        int val = stack.pop();

        // Decrease its frequency
        int newFreq = freq.get(val) - 1;

        freq.put(val, newFreq);

        // If this frequency stack becomes empty,
        // decrease maxFreq
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}