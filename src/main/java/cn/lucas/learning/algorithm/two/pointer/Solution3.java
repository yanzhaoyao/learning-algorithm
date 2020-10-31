package cn.lucas.learning.algorithm.two.pointer;

/**
 * 双指针|接雨水
 *
 * @author lucas
 * @date 2020-10-25
 * @see leetcode : <https://leetcode-cn.com/problems/trapping-rain-water/>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution3().trap(nums));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (leftHeight > height[left + 1]) {
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left++;
            } else {
                if (rightHeight > height[right - 1]) {
                    sum += rightHeight - height[right - 1];
                } else {
                    rightHeight = height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }
}
