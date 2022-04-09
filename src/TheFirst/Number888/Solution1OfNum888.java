package TheFirst.Number888;

import java.util.Arrays;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 */
public class Solution1OfNum888 {
    public static void main(String[] args) {
        //[28,30,31,26,27,1,8,16,12,10,35,23,9,33,9,15,11,34,26,1]
        //[71,18,27,11,60,56,26,100,40,14]
        new Solution().fairCandySwap(new int[]{28, 30, 31, 26, 27, 1, 8, 16, 12, 10, 35, 23, 9, 33, 9, 15, 11, 34, 26, 1},
                new int[]{71, 18, 27, 11, 60, 56, 26, 100, 40, 14});
    }

}

/**
 * 计算两个原始的数组和之差X，交换的两个数的差需要是X/2即可满足条件
 * 注意: 大的数组应该是选大的进行交换
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int j : B) {
            sumB += j;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int temp = sumA - (sumA + sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == temp) {
                ans[0] = A[i];
                ans[1] = B[j];
                break;
            } else if (A[i] - B[j] > temp) {
                j++;
            } else if (A[i] - B[j] < temp) {
                i++;
            }
        }

        System.out.println(ans[0] + "  " + ans[1]);
        return ans;
    }
}