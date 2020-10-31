package cn.lucas.learning.algorithm.sort;

import java.util.Random;

/**
 * 排序|冒泡、插入、选择、快速、并归
 *
 * @author lucas
 * @date 2020-10-31
 */
public class SortEx {
    public static void main(String[] args) {
        int[] array = new int[10000];
        // bubble sort
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        bubbleSort(array);
        long end1 = System.currentTimeMillis();
        System.out.println("bubble sort:" + (end1 - start1));
        // insert sort
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        insertSort(array);
        long end2 = System.currentTimeMillis();
        System.out.println("insert sort:" + (end2 - start2));
        // select sort
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        selectSort(array);
        long end3 = System.currentTimeMillis();
        System.out.println("select sort:" + (end3 - start3));
        // quick sort
        long start4 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        quickSort(array);
        long end4 = System.currentTimeMillis();
        System.out.println("quick sort:" + (end4 - start4));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        int insertNode;
        int j;
        for (int i = 1; i < array.length; i++) {
            // 从第二个数开始作为要插入的数
            // 要插入的数临时去出来
            insertNode = array[i];
            // 要插入的数的前一个数的下标
            j = i - 1;
            int jtemp = j;
            // 要插入的数 < 要插入的数前一个数（每次往前走一个）
            while (j >= 0 && array[j] > insertNode) {
                // 把前一个数往后放
                array[j + 1] = array[j];
                // 下标往前走
                j--;
            }
            if (jtemp != j) {
                // 要插入的数插到最前面
                array[j + 1] = insertNode;
            }
        }
    }

    public static void selectSort(int[] array) {
        int pos;
        for (int i = 0; i < array.length; i++) {
            pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[pos] > array[j]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
        }
    }

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
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
        sort(array, start, right);
        sort(array, left, end);
    }

}
