package cn.lucas.learning.algorithm.two.pointer;

import java.util.Arrays;

/**
 * 双指针|有效三角形的个数
 *
 * @author lucas
 * @date 2020-10-25
 * @see leetcode : <https://leetcode-cn.com/problems/valid-triangle-number>
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4, 1};
        System.out.println(new Solution2().triangleNumber(nums));

    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}
