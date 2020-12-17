package cn.lucas.learning.algorithm;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出积为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 14

因为 nums[0] * nums[1] = 2 * 7 = 14
所以返回 [0, 1]
*/
public class TestA {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] solve = solve(nums, 22);
        for (int i : solve) {
            System.out.println(i);
        }
    }

    public static int[] solve(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null) {
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1 + i; j < nums.length - 1; j++) {
                if (nums[i] * nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
