package leetcode.editor.cn;

/**
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找
 * 出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * Related Topics 数组 哈希表 排序 👍 1033 👎 0
 */


/**
 * 时间：2023-01-03 11:32:49
 * 题目编号：剑指 Offer 03
 * 题目标题：数组中重复的数字
 */
public class NumOffer03_ShuZuZhongZhongFuDeShuZiLcof {

    public static void main(String[] args) {
        //Solution solution = new Num剑指 Offer 03_ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这道题在原书上绝对不是简单级别啊！
         * 它考察的是程序员的沟通能力，先问面试官要时间/空间需求！！！
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
//            //使用字典，时间优先
//            HashSet<Integer> set = new HashSet<Integer>();
//            for (int i = 0; i < nums.length; i++) {
//                int temp = nums[i];
//                if (set.contains(temp)) {
//                    return temp;
//                } else {
//                    set.add(temp);
//                }
//            }
//            return -1;


            //使用原地交换，空间优先
            //题目说明尚未被充分使用，即 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内 。
            // 此说明含义：数组元素的索引和值是一对多的关系。
            //至少有一个索引，对应两个值
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }


            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}