package cn.lucas.learning.algorithm.heap;

import java.util.Random;

/**
 * 快排最优解|数组中的第K个最大(小)元素
 *
 * @author lucas
 * @date 2020-11-1
 * @link <https://leetcode-cn.com/problems/kth-largest-element-in-an-array/>
 */
public class KthLagestElementInAnArrayByQuickSort {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        System.out.println(kthLagestElementInAnArray(array, 2));
    }

    public static int kthLagestElementInAnArray(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return -1;
        }
        quicksSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("--------------------------------------");
        return array[k - 1];
    }

    private static void quicksSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[end];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] > pivot) {
                left++;
            }
            while (left <= right && array[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        quicksSort(array, start, right);
        quicksSort(array, left, end);
    }

}
