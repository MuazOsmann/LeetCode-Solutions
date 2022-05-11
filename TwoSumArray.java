public class TwoSumArray {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
    //Testing the code.
    public static void main(String[] args) {
        TwoSumArray twoSumArray = new TwoSumArray();
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] result = twoSumArray.twoSum(numbers, target);
        System.out.println("["+result[0] + "," + result[1] + "]");
    }
}
