package Top_Interview_Quesitons_In_2018.onlyAppearsOnce;

import java.util.Arrays;

public class onlyAppearsOnce {
    public static void main(String[] args) {
        new Solution().singleNumber(new int[]{4, 1, 2, 1, 2});
    }
}

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = -1;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    i++;
                } else {
                    result = nums[i];
                    break;
                }
            } else {
                result = nums[i];
                break;
            }
        }
        System.out.println(result);

        return result;
    }
}