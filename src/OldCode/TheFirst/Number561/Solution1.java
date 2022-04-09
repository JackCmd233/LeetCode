package OldCode.TheFirst.Number561;

import java.util.Arrays;

/**
 * @author liu
 * @date 2019.4.7
 * <p>
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new Solution().arrayPairSum(nums));
    }
}

/**
 * 把传入的数组进行排序,对排序结果进行处理
 * 把已经排序的数组分成两部分, A和B两部分
 * 每一个数组对,都是从A中选一个,从B中选一个,组成
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        int length = nums.length;
        Arrays.sort(nums);
        int[][] ints = new int[length / 2][2];


        for (int i = 0, j = 0; i < ints.length && j < length; i++) {
            ints[i][0] = nums[j];
            j++;
            ints[i][1] = nums[j];
            j++;
        }

        for (int i = 0; i < ints.length; i++) {
            result += ints[i][0];
        }

        return result;
    }
}

