class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        int max = Integer.MIN_VALUE;
        // From right to left.
        for (int i = arr.length - 1; i >= 0; i--) {
            // If it's on the rightest element.
            if (i == arr.length - 1) {
                result[i] = -1;
                max = arr[i];
            } else {
                result[i] = max;
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        return result;
    }
}
