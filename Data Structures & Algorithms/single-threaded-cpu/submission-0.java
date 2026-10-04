

class Solution {

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // Store [enqueueTime, processingTime, index]
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(sortedTasks, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        // Min heap
        // First priority: processing time
        // Second priority: index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }

                return Integer.compare(a[2], b[2]);
            }
        );

        int[] result = new int[n];

        int resultIndex = 0;
        int taskIndex = 0;

        long currentTime = 0;

        while (resultIndex < n) {

            // If heap is empty, CPU is idle
            // Jump directly to the next task's enqueue time
            if (pq.isEmpty() && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }

            // Add all tasks that are available
            while (taskIndex < n
                    && sortedTasks[taskIndex][0] <= currentTime) {

                pq.offer(sortedTasks[taskIndex]);
                taskIndex++;
            }

            // Pick the task according to priority
            int[] currentTask = pq.poll();

            result[resultIndex] = currentTask[2];
            resultIndex++;

            // Process the task
            currentTime += currentTask[1];
        }

        return result;
    }
}