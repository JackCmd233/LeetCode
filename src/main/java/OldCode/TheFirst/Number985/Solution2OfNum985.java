package OldCode.TheFirst.Number985;

public class Solution2OfNum985 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] result = new int[A.length];
        Solution2 solution2 = new Solution2();
        result = solution2.sumEvenAfterQueries(A, queries);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}

/**
 * 双指针方法
 * 首先,我们把所有偶数都加起来even_sum
 * <p>
 * 接下来,有4种可能
 * <p>
 * 第一种,本身是偶数a,加上一个数num后,仍然是偶数,我们只需even_sum加上num;
 * <p>
 * 第二种,本身是偶数a,加上一个数num后,变成奇数,我们需even_sum减去本身这个数a;
 * <p>
 * 第三种,本身是奇数b,加上一个数num后,变成偶数,我们even_sum需加上b和num;
 * <p>
 * 第四种,本身是奇数b,加上一个数num后,变成奇数,我们把even_sum不变.
 * <p>
 * 时间复杂度O(n).
 */
class Solution2 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sumBefore = 0;
        int temp = 0;

        //求出在运算前的值
        for (int tempA : A) {
            if (tempA % 2 == 0) {
                sumBefore += tempA;
            }
        }
        //System.out.println(sumBefore);
        //result[0] = sumBefore;

        for (int i = 0; i < A.length; i++) {
            temp = A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];

            if (A[queries[i][1]] % 2 == 0 && temp % 2 == 0) {
                //如果是偶数变偶数,相当于加上两个偶数的差
                sumBefore += (A[queries[i][1]] - temp);
                result[i] = sumBefore;
            } else if (A[queries[i][1]] % 2 == 0 && !(temp % 2 == 0)) {
                //如果是奇数变偶数,相当于加上新的偶数
                sumBefore += A[queries[i][1]];
                result[i] = sumBefore;
            } else if (!(A[queries[i][1]] % 2 == 0) && temp % 2 == 0) {
                //如果是偶数变奇数,相当于
                // 减去原来的偶数
                sumBefore -= temp;
                result[i] = sumBefore;
            } else {
                //如果是奇数变奇数,不做任何操作
                result[i] = sumBefore;;
            }
        }


        return result;
    }
}
