package cn.lucas.learning.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆|从数据流里面找中位数
 *
 * @author zhaoyao.yan@ximalaya.com
 * @date 2020-11-02
 * @link <>https://www.lintcode.com/problem/find-median-from-data-stream/description</>
 * 描述
 * <p>
 * 数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。
 * <p>
 * 说明
 * 中位数的定义：
 * <p>
 * 这里的中位数不等同于数学定义里的中位数。
 * 中位数是排序后数组的中间值，如果有数组中有n个数，则中位数为A[(n-1)/2]A[(n−1)/2]。
 * 比如：数组A=[1,2,3]的中位数是2，数组A=[1,19]的中位数是1。
 * 样例
 * <p>
 * 样例1
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [1,1,2,2,3]
 * 样例说明：
 * [1] 和 [1,2] 的中位数是 1.
 * [1,2,3] 和 [1,2,3,4] 的中位数是 2.
 * [1,2,3,4,5] 的中位数是 3.
 * <p>
 * 样例2
 * <p>
 * 输入: [4,5,1,3,2,6,0]
 * 输出: [4,4,4,3,3,3,3]
 * 样例说明：
 * [4], [4,5] 和 [4,5,1] 的中位数是 4.
 * [4,5,1,3], [4,5,1,3,2], [4,5,1,3,2,6] 和 [4,5,1,3,2,6,0] 的中位数是 3.
 */
public class FindMedianFromDataStreamByHeap {

    public static void main(String[] args) {

    }

    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int[] result = new int[nums.length];
        // write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue(nums.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int number = nums[0];
        result[0] = number;
        for (int i= 1; i < nums.length; i++) {
            if(nums[i] > number){
                minHeap.add(nums[i]);
            }else{
                maxHeap.add(nums[i]);
            }
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1){
                if(minHeap.size() > maxHeap.size()){
                    maxHeap.add(number);
                    number = minHeap.poll();
                }else{
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }else{
                if(maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number){
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }
            result[i] = number;
        }
        return result;
    }
}
