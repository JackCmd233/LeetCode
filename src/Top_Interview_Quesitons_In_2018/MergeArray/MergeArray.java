package Top_Interview_Quesitons_In_2018.MergeArray;

import java.util.Arrays;


/**
 * @author liu
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeArray {
    public static void main(String[] args) {
        new Solution().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
