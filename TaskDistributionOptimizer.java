/*
Mission:
You are given an array A representing tasks, where each task is represented by an integer. The tasks need to be assigned to a set of workers. Each worker has a load limit of 10. Tasks will be assigned to workers one by one in the order they appear in the array.

For each task, if there is a worker whose current load is less than or equal to their load limit (10), and adding the current task does not exceed the worker's load limit, assign the task to that worker. If there is no such worker, the task will create a new worker.

Your task is to find the minimum number of workers required to handle all the tasks.

Write a function that, given a non-empty array A containing N integers (representing the task loads), returns the minimum number of workers required to complete all the tasks.

Example:
Given A = [5, 4, 7, 6, 3], the function should return 3.

Explanation:
For the first task (5), there is no worker, so the task creates a new worker.
Worker 1 = [5]
For the second task (4), it can be assigned to Worker 1 since the load will be 5 + 4 = 9, which is under the limit of 10.
Worker 1 = [5, 4]
For the third task (7), there is no worker with a current load that will not exceed the limit. So, it creates a new worker.
Worker 1 = [5, 4]
Worker 2 = [7]
For the fourth task (6), it cannot be assigned to Worker 1 (since 5 + 4 + 6 = 15 exceeds 10), but it can be assigned to Worker 2.
Worker 1 = [5, 4]
Worker 2 = [7, 6]
For the fifth task (3), it can be assigned to Worker 1 since 5 + 4 + 3 = 12 is under the limit of 10.
Worker 1 = [5, 4, 3]
Worker 2 = [7, 6]
Since 3 workers are needed, the function should return 3.

Constraints:
N is an integer within the range [1..1,000].
Each element of array A is an integer within the range [1..10,000].
The load limit for each worker is 10.
*/

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

    static int solution(Integer[] A) {
        Integer[] workers = new Integer[A.length]; // Array to track each worker's load
        int workerCount = 0;
        
        // Iterate through each task
        for (int i = 0; i < A.length; i++) {
            boolean assigned = false;
            
            // Try to assign the task to an existing worker
            for (int j = 0; j < workerCount; j++) {
                if (workers[j] + A[i] <= 10) {
                    workers[j] += A[i]; // Assign the task to this worker
                    assigned = true;
                    break;
                }
            }
            
            // If no worker can take the task, create a new worker
            if (!assigned) {
                workers[workerCount] = A[i];
                workerCount++;
            }
        }

        return workerCount; // Return the number of workers used
    }

    public static void main(String[] args) {
        // Read input and solve the problem
        Scanner in = new Scanner(System.in);
        Integer[] A = getIntegerArray(in.next());
        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}

