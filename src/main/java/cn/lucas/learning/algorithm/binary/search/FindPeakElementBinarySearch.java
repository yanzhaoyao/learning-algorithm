package cn.lucas.learning.algorithm.binary.search;

/**
 * 二分查找|寻找峰值
 *
 * @author lucas
 * @date 2020-10-24
 * @see leetcode : <https://leetcode-cn.com/problems/find-peak-element/>
 */
public class FindPeakElementBinarySearch {

    public static void main(String[] args) {
        int[] num = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(new FindPeakElementBinarySearch().findPeakElement(num));
    }

    public int findPeakElement(int nums[]) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // 下降峰
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            }
            // 上升峰
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
