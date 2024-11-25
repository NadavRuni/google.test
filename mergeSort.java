public static Integer[] mergeSort(Integer[] arr) {
    if (arr.length <= 1) {
        return arr;
    }
    int mid = arr.length / 2;
    Integer[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    Integer[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(left, right);
}

private static Integer[] merge(Integer[] left, Integer[] right) {
    int leftSize = left.length;
    int rightSize = right.length;
    Integer[] result = new Integer[leftSize + rightSize];
    int i = 0, j = 0, k = 0;

    while (i < leftSize && j < rightSize) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++];
        } else {
            result[k++] = right[j++];
        }
    }

    while (i < leftSize) {
        result[k++] = left[i++];
    }

    while (j < rightSize) {
        result[k++] = right[j++];
    }

    return result;
}

