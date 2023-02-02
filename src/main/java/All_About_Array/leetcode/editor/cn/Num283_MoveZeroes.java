package All_About_Array.leetcode.editor.cn;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * Related Topics 数组 双指针 👍 1845 👎 0
 */


import java.util.Arrays;

/**
 * 时间：2023-01-13 11:28:31
 * 题目编号：283
 * 题目标题：移动零
 */
public class Num283_MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new Num283_MoveZeroes().new Solution();

        // TO TEST
        int[] testExample = {1, 0, 0};
        solution.moveZeroes(testExample);
        System.out.println(Arrays.toString(testExample));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针操作(快慢双指针):
         * 快指针：不停止，勇往直前，寻找0
         * 慢指针：用于记录更新新数组的下标位置\
         * 在寻找完成后，要给尾部剩下的元素赋值为0，从而达到题目要求。
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            if (nums.length <= 1) {
                //数组为空, 或者只有一个元素, 直接返回即可
                return;
            }

            int leftIndex = 0;
            int rightIndex = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    //设计

                    leftIndex++;
                }

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}