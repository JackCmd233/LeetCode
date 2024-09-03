package leetcode.editor.cn;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 
//输入: s = "abc"
//输出: true
// 
//
// 限制： 
//
// 
// 0 <= len(s) <= 100 
// s[i]仅包含小写字母 
// 如果你不使用额外的数据结构，会很加分。 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 334 👎 0


import java.util.HashMap;
import java.util.Set;

/**
 * 时间：2024-09-03 17:07:34
 * <p>
 * 题目编号：面试题 01.01
 * <p>
 * 题目标题：判定字符是否唯一
 */
public class Num_IsUniqueLcci {

    public static void main(String[] args) {
        Solution solution = new Num_IsUniqueLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            if (astr == null || astr.isEmpty()) {
                return true;
            }

            char[] charArray = astr.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < charArray.length; i++) {
                Character c = charArray[i];
                if (map.containsKey(c)) {
                    Integer i1 = map.get(c);
                    i1 += 1;
                    map.put(c, i1);
                } else {
                    map.put(c, 1);
                }
            }

            Set<Character> characters = map.keySet();
            for (Character character : characters) {
                Integer value = map.get(character);
                if (value > 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}