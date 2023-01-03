package leetcode.editor.cn;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返
 * 回左旋转两位得到的结果"cdefgab"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= k < s.length <= 10000
 * <p>
 * <p>
 * Related Topics 数学 双指针 字符串 👍 331 👎 0
 */


/**
 * 时间：2022-12-15 18:32:15
 * 题目编号：剑指 Offer 58 - II
 * 题目标题：左旋转字符串
 */
public class NumOffer58II_ZuoXuanZhuanZiFuChuanLcof {

    public static void main(String[] args) {
        //Solution solution = new Num剑指 Offer 58 - II_ZuoXuanZhuanZiFuChuanLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 方法一:
//         * 用字符串截取, 简单操作
//         * @param s
//         * @param n
//         * @return
//         */
//        public String reverseLeftWords(String s, int n) {
//            String sub1 = s.substring(0, n);
//            String sub2 = s.substring(n, s.length());
//            return sub2 + sub1;
//        }

//        /**
//         * 方法二:
//         * 字符串的拼接与旋转有一个挺好的办法 就是将字符串倍增成为两个同样的字符串拼接的长字符串
//         * 然后想旋转均可
//         * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/zi-fu-chuan-pin-jie-yu-qie-fen-pei-tu-by-1smm/
//         * @param s
//         * @param n
//         * @return
//         */
//        public String reverseLeftWords(String s, int n) {
//            String str2 = s + s;
//            return str2.substring(n, n + s.length());
//        }

        /**
         * 方法三:
         * 对字符串取余.
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            StringBuilder result = new StringBuilder();
            int length = s.length();
            for (int i = n; i < n + length; i++) {
                result.append(s.charAt(i % length));
            }
            return result.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}