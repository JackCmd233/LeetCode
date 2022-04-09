package OldCode.TheFirst.Number985;

/**
 * @author liu CMDEGR
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 */
public class Solution1OfNum985 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] result = new int[A.length];
        Solution solution = new Solution();
        result = solution.sumEvenAfterQueries(A, queries);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}

/**
 * 思路:
 * 根据queries[i][1]确定是queries[i][0]与那一个数相加
 * <p>
 * 每次加完数之后,都需要对所有的偶数相加,把和放到result[i]的位置
 */
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    result[i] += A[j];
                }
            }
        }

        return result;
    }
}
