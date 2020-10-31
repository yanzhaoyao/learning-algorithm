package cn.lucas.learning.algorithm.binary.search;

/**
 * 二分查找|搜索排序数组
 *
 * @author lucas
 * @date 2020-10-23
 */
public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] num = {1, 4, 7, 9, 10, 14, 16, 20, 56, 89};
        System.out.println(new BasicBinarySearch().getIndex(num, 90));
    }

    public int getIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > target) {
                end = mid;
            }
            if (num[mid] < target) {
                start = mid;
            }
        }
        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;
    }
}
