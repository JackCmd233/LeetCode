package OldCode.TheFirst.Number509;

/**
 * @author liu
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 */
public class Solution1 {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        int r = solution.fib(n);

        System.out.println(r);
    }

}

/**
 * 使用迭代方法解决问题
 */
class Solution {
    public int fib(int N) {
        int r = 0;
        r = fob(N);

        return r;
    }

    public int fob(int N) {
        int t = 0;
        if (N == 0) {
            t = 0;
        } else if (N == 1) {
            t = 1;
        } else {
            t = fob(N - 1) + fob(N - 2);
        }

        return t;
    }
}
