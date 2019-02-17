package Number62;

/**
 * @author liu
 * @version 1.0
 * @date 2019年2月17日 07:57:46
 * <p>
 * * 机器人往右走总共会走6步，也就是m-1步；往下共走2步，n-1步。
 * *
 * * 一共走了m-1+n-1 = m+n-2 （步）
 * *
 * * 也就是说无论路线如何不同，总步数不会变，一直为m+n-2 （步）
 * *
 * * 现在就需要考虑在m+n-2 （步）里面有几种【往右走】的方式
 * *
 * * 问题就变成了组合问题：在m+n-2 里面挑选m-1个元素的组合总数
 * *
 * * https://zhuanlan.zhihu.com/p/48681725
 */
public class Solution1OfNum62 {
    public static void main(String[] args){
        Solution solution = new Solution();

         int m=7, n=3;

        System.out.println(solution.uniquePaths(m,n));
    }
}

/**
 * * 不同路径
 * * 涉及到这一类题的时候，并不需要老老实实把全部可行路径找出来，然后返回全部可行路径的数量
 * * 只需要找到【产生全部可行路径总数】的规律即可，不需要把每一条路都找出来
 * *
 * *
 * * 上一次的结果要为下一次计算提供服务的时候可以使用动态规划：DP
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {

                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}