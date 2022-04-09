package TheFirst.Number167;

/**
 * @author liu
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] r = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(r[0] + "  " + r[1]);
    }
}

/**
 * 问题已经解决,
 * 采用双指针方法
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{0, 0};

        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                l++;
                r++;
                result[0] = l;
                result[1] = r;
                return result;
            } else if (numbers[l] + numbers[r] <= target) {
                l++;
            } else {
                r--;
            }
        }


        return result;
    }
}