/*
Mission:
You are given an array A representing heights of students. All the students are asked to stand in rows. The students arrive one by one, sequentially (as their heights appear in A). For the i-th student, if there is a row in which all the students are taller than A[i], the student will stand in one of such rows. If there is no such row, the student will create a new row. Your task is to find the minimum number of rows created.

For example, given A = [5, 4, 3, 6, 1], the function should return 2.

Students will arrive in sequential order from A[0] to A[N−1]. So, the first student will have height = 5, the second student will have height = 4, and so on.

For the first student, there is no row, so the student will create a new row.

Row1 = [5]

For the second student, all the students in Row1 have height greater than 4. So, the student will stand in Row1.

Row1 = [5, 4]

Similarly, for the third student, all the students in Row1 have height greater than 3. So, the student will stand in Row1.

Row1 = [5, 4, 3]

For the fourth student, there is no row in which all the students have height greater than 6. So, the student will create a new row.

Row1 = [5, 4, 3]
Row2 = [6]

For the fifth student, all the students in Row1 and Row2 have height greater than 1. So, the student can stand in either of the two rows.

Row1 = [5, 4, 3, 1]
Row2 = [6]

Since two rows are created, the function should return 2.

Assume that:
N is an integer within the range [1..1,000]
each element of array A is an integer within the range [1..10,000]
*/

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

    static int solution(Integer[] A) {
        Integer[] first = new Integer[1000];
        Integer[] last = new Integer[1000];
        int i, j, ans = 0, count = 0;
        if (A.length == 0) return 0;
        for (i = 0; i < A.length; i++) {
            j = 0;
            while ((j != -1) && (j < 1000)) {
                if (first[j] == null) {
                    first[j] = A[i];
                    last[j] = A[i];
                    j = -1;
                    count++;
                } else if (A[i] > first[j]) {
                    j++;
                } else {
                    if (A[i] <= last[j]) {
                        last[j] = A[i];
                        j = -1;
                    } else {
                        j++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
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

