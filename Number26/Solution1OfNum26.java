package Number26;

import java.util.Arrays;

/**
 * 代码已经通过
 *
 * @author liu
 * @date 2019.4.6
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution1OfNum26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3, 4};
        Solution solution = new Solution();
        int position = solution.removeDuplicates(nums);

        for (int i = 0; i < position; i++) {
            System.out.println(nums[i]);
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 1;
        Arrays.sort(nums);

        int repeat = -1000;
        int startPosition = 0;
        int endPosition = 0;
        int position = 0;
        //分别是重复元素段落的 开始位置 和结束位置
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[startPosition]) {
                nums[i] = repeat;
            } else {
                startPosition = i;
            }
        }

        //重复段落 开始位置和结束位置 归0
        startPosition = 0;
        endPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = startPosition; j < nums.length; j++) {
                if (endPosition + 1 < nums.length && nums[endPosition + 1] == repeat) {
                    endPosition++;
                } else {
                    break;
                }
            }

            nums[position] = nums[startPosition];
            position++;
            if ((startPosition + 1) < nums.length && (endPosition + 1) < nums.length) {
                startPosition = endPosition + 1;
                endPosition++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] != nums[i - 1]) {
                //System.out.println(nums[i]);
                result++;
            }
        }

        return result;
    }
}
