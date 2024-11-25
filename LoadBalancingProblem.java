import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Mission: Distribute processes across two servers such that the absolute difference 
 * between their total loads is minimized. 
 * 
 * Each process's load is represented as an integer. The program computes the minimum 
 * possible difference by finding a subset of processes whose total load is as close as 
 * possible to half of the total load.
 *
 * Example:
 * Input: 1,2,3,4,5
 * Output: 1 (e.g., distribute {1,2,4} on one server and {3,5} on the other)
 *
 * Assumptions:
 * - N (number of processes) is in the range [1..1,000].
 * - The sum of all loads does not exceed 100,000.
 */
class Solution {
    public static int sumarray(Integer[] loads) {
        int sum = 0;
        for (int i = 0; i < loads.length; i++) {
            sum += loads[i];
        }
        return sum;
    }

    public static String ToString(boolean[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            ans += i + " = " + a[i] + " , ";
        }
        return ans;
    }

    static int solution(Integer[] loads) {
        int sum = sumarray(loads);
        int goal = sum / 2;
        boolean[] make = new boolean[goal + 1];
        make[0] = true;
        int add = 0;
        System.err.println(ToString(make));

        for (int i = 0; i < loads.length; i++) {
            for (int j = goal; j >= loads[i]; j--) {
                make[j] = make[j] || make[j - loads[i]]; // Update the DP array
                if (make[j]) {
                    System.err.println();
                    System.err.println("change!");
                    System.err.println();
                }
                System.err.println("Trying to form sum " + j + " with load " + loads[i]);
                System.err.println(ToString(make));
            }
        }
        int closestSum = 0;
        for (int j = goal; j >= 0; j--) {
            if (make[j]) {
                closestSum = j;
                break;
            }
        }
        int othersum = sum - closestSum;
        // System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
        return Math.abs(othersum - closestSum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] loads = getIntegerArray(in.next());

        System.out.print(solution(loads));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
              .map(Integer::valueOf)
              .toArray(Integer[]::new);
    }
}

