class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (numberMap.containsKey(target - n)) {
                result[0] = i;
                result[1] = numberMap.get(target - n);
                break;
            }
            numberMap.put(numbers[i], i);
        }
        return result;
    }
}
