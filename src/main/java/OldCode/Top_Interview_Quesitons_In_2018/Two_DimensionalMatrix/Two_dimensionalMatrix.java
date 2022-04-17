package OldCode.Top_Interview_Quesitons_In_2018.Two_DimensionalMatrix;

public class Two_dimensionalMatrix {
    public static void main(String[] args) {
/*        new Solution().searchMatrix(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}},20);
    */
        new Solution().searchMatrix(new int[][]{{-5}}, -10);
    }
}

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean bool = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int b_m = 0;
        int b_n = n - 1;

        //如果还在 二维矩阵的范围内

        while (true) {
            if (b_m < m && 0 <= b_m && 0 <= b_n && b_n < n) {
                if (target > matrix[b_m][b_n]) {
                    b_m++;
                } else if (target < matrix[b_m][b_n]) {
                    b_n--;
                } else {
                    bool = true;
                    break;
                }

            } else {
                bool = false;
                break;
            }
        }

        System.out.println(bool);
        return bool;
    }
}
