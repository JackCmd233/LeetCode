package leetcode.editor.cn;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
 * position-of-element-in-sorted-array/
 * <p>
 * Related Topics 数组 二分查找 👍 387 👎 0
 */


import java.util.Arrays;

/**
 * 时间：2023-01-04 16:19:05
 * 题目编号：剑指 Offer 53 - I
 * 题目标题：在排序数组中查找数字 I
 */
public class NumOffer53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    public static void main(String[] args) {
        //Solution solution = new Num剑指 Offer 53 - I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 最简单粗暴，时间复杂度O(n), 空间复杂度O(1).
//         * @param nums
//         * @param target
//         * @return
//         */
//        public int search(int[] nums, int target) {
//            int result = 0;
//            for (int i = 0; i < nums.length; i++) {
//                int temp = nums[i];
//                if (temp == target) {
//                    result++;
//                }
//            }
//            return result;
//        }

        /**
         * 数组已经排序，寻求时间优先
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int result = 0;
            //先利用二分查找法，快速找到位置
            int index = Arrays.binarySearch(nums, target);
            if (index <= -1) {
                //不包含Target
                return result;
            }

            //往前探究，判断之前是否有重复的元素。
            for (int i = index; i >= 0; i--) {
                int temp = nums[i];
                if (temp == target) {
                    result++;
                } else {
                    break;
                }
            }

            //往后探究，判断之后是否有重复元素。
            for (int i = index + 1; i < nums.length; i++) {
                int temp = nums[i];
                if (temp == target) {
                    result++;
                } else {
                    break;
                }
            }

            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}