package Number867;

/**
 * @author liu
 * @date 2019.4.7
 * <p>
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class Solution1OfNum867 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] r = new Solution().transpose(a);

        for (int[] temp : r) {
            for (int t2 : temp) {
                System.out.println(t2);
            }
            System.out.println(" ");
        }
    }
}

/**
 * 根据对角线两边的关系
 * A[i][j] = A[j][i]  //行和列进行交换
 * 注意只有在对角线一侧的元素才需要进行遍历
 */
class Solution {
    public int[][] transpose(int[][] A) {
        int[][] result;

        int h = A.length;
        int l = A[0].length;
        int length = h * l;
        int t = 0;

        if (h == l) {
            //当A为一个正方形时
            //i表示行,j表示列
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (i < j) {
                        t = A[i][j];
                        A[i][j] = A[j][i];
                        A[j][i] = t;
                    }
                }
            }
            result = A.clone();
        } else {
            //当A为一个长方形时
            //长与宽进行交换
            //i表示行,j表示列
            result = new int[l][h];
            int[] intsTemp = new int[l];
            //读取每一行
            for (int i = 0; i < h; i++) {
                intsTemp = A[i].clone();
                for (int j = 0; j < l; j++) {
                    result[j][i] = intsTemp[j];
                }
            }
        }


        return result;

    }
}