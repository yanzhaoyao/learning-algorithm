package cn.lucas.learning.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 堆|数组中的第K个最大(小)元素
 *
 * @author lucas
 * @date 2020-11-1
 * @link <https://leetcode-cn.com/problems/kth-largest-element-in-an-array/>
 */
public class KthLagestElementInAnArrayByHeap {

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
            System.out.println(array[i]);
        }
        System.out.println("------------------------------------");
        System.out.println(kthLagestElementInAnArray(array, 2));
    }

    public static int kthLagestElementInAnArray(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return -1;
        }
        // 声明最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : array) {
            queue.offer(i);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

}
