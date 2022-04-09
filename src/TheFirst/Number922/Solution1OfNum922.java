package TheFirst.Number922;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liu
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class Solution1OfNum922 {
    public static void main(String[] args) {
        int[] a = {4, 2, 5, 7};
        int[] result = new Solution().sortArrayByParityII(a);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}

/**
 *
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        int[] result = A;

        //evenSort 偶数
        //odd_numberSort 奇数
        ArrayList evenSort = new ArrayList();
        ArrayList odd_numberSort = new ArrayList();
        int even = 0;
        int odd_number = 0;

        for (int i = 0, temp = 0; i < A.length; i++) {
            temp = A[i];
            if (temp % 2 == 0) {
                evenSort.add(temp);
            } else {
                odd_numberSort.add(temp);
            }
        }

        System.out.println("evenSort:" + evenSort);

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = (int) evenSort.get(even);
                even++;
            } else {
                A[i] = (int) odd_numberSort.get(odd_number);
                odd_number++;
            }
        }

        return result;
    }
}