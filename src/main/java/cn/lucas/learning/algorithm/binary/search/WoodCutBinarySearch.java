package cn.lucas.learning.algorithm.binary.search;

/**
 * 二分查找|搜索排序数组
 *
 * @author lucas
 * @date 2020-10-25
 * @link <https://www.lintcode.com/problem/wood-cut/description>
 */
public class WoodCutBinarySearch {

    public static void main(String[] args) {
        int[] num = {232, 124, 456};
        System.out.println(new WoodCutBinarySearch().woodCut(num, 2));
    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 0;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int pieces = getPieces(L, mid);
            if (pieces >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPieces(L, end) >= k) {
            return end;
        }
        if (getPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int getPieces(int[] l, int woodLength) {
        int pieces = 0;
        for (int i : l) {
            pieces += i / woodLength;
        }
        return pieces;
    }

    private int getMax(int[] l) {
        int max = l[0];
        for (int i = 0; i < l.length; i++) {
            if (max < l[i]) {
                max = l[i];
            }
        }
        return max;
    }
}
