package cn.lucas.learning.algorithm.binary.search;

/**
 * 二分查找|搜索旋转排序数组
 *
 * @author lucas
 * @date 2020-10-23
 * @see leetcode : <https://leetcode-cn.com/problems/search-in-rotated-sorted-array/>
 */
public class InRotatedBinarySearch {

    public static void main(String[] args) {
        int[] num = {14, 16, 20, 56, 89, 1, 4, 7, 9, 10};
        System.out.println(new InRotatedBinarySearch().search2(num, 10));
    }

    public int search(int[] num, int target) {
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
            if (num[mid] > num[start]) {
                if (target <= num[mid] && target >= num[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= num[mid] && target <= num[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
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

    public int search2(int[] num, int target) {
        int lo = 0, hi = num.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((num[0] > target) ^ (num[0] > num[mid]) ^ (target > num[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && num[lo] == target ? lo : -1;
    }
}