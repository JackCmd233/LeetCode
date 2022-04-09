package TheFirst.Number832;

public class Solution1OfNum832 {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        Solution solution = new Solution();
        int[][] res = solution.flipAndInvertImage(A);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println("");
        }

    }
}

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int result[][] = new int[A.length][];
        int Lpoint = 0, Rpoint = A[0].length - 1;
        int temp;
        //第一步,翻转(首尾互换)
        for (int i = 0; i < A.length; i++) {
            Lpoint = 0;
            Rpoint = A[0].length - 1;
            for (int j = 0; j < A[0].length; j++) {
                //如果需要首尾互换的两个数相同,就不需要互换
                if (A[i][Lpoint] == A[i][Rpoint]) {
                    Lpoint++;
                    Rpoint--;
                } else {
                    if (Lpoint < Rpoint) {
                        temp = A[i][Lpoint];
                        A[i][Lpoint] = A[i][Rpoint];
                        A[i][Rpoint] = temp;
                        Lpoint++;
                        Rpoint--;
                    } else {
                        break;
                    }


                }
            }
        }

/*        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                //System.out.print(A[i][j]);
                switch (A[i][j]) {
                    case 1:
                        A[i][j] = 0;
                        break;
                    case 0:
                        A[i][j] = 1;
                        break;

                }
                //System.out.print(A[i][j]);
            }
            //System.out.println("");
        }*/

        //第二步,反转(0与1互换)
        result = A.clone();

        return result;
    }
}
//0000 1111
//OOOO llll
//oooo LLLL
//