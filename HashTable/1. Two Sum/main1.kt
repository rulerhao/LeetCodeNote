class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
    
    private int[] mergeSort(int arr[]) {
        int arrLength = arr.length;
        if (arr.length < 2) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[arrLength - mid];
        
        leftArr = arrayCopy(arr, 0, leftArr.length);
        rightArr = arrayCopy(arr, mid, rightArr.length);
            
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }
    
    private int[] arrayCopy(int[] resArr, int resPos, int length) {
        int resultArr[] = new int[length];
        for (int i = 0; i < length; i++) {
            resultArr[i] = resArr[resPos + i];
        }
        
        return resultArr;
    }
    
    private int[] merge(int[] leftArr, int[] rightArr) {
        int resultArr[] = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArr.length & j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                resultArr[k++] = leftArr[i++];
            }
            else {
                resultArr[k++] = rightArr[k++];
            }
            while (i < leftArr.length) {
                resultArr[k++] = leftArr[i++];
            }
            while (j < rightArr.length) {
                resultArr[k++] = rightArr[j++];
            }
        }
        return resultArr;
    }
}
