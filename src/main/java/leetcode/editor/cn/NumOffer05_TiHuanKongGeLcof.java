package leetcode.editor.cn;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * Related Topics 字符串 👍 381 👎 0
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 时间：2022-12-15 17:45:54
 * 题目编号：剑指 Offer 05
 * 题目标题：替换空格
 */
public class NumOffer05_TiHuanKongGeLcof {

    public static void main(String[] args) {
        Solution solution = new NumOffer05_TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        /**
//         * 使用String自带的replaceAll
//         * @param s
//         * @return
//         */
//        public String replaceSpace(String s) {
//            char[] chars = s.toCharArray();
//            String s1 = s.replaceAll(" ", "\\%20");
//            return s1;
//        }
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                if (' ' == temp) {
                    sb.append("\\%20");
                } else {
                    sb.append(temp);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}