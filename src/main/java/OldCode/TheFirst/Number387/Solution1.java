package OldCode.TheFirst.Number387;


import java.util.*;

/**
 * @author liu
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution1 {
    public static void main(String[] args) {
        new Solution().firstUniqChar("");
    }
}

class Solution {
    public int firstUniqChar(String s) {
        int result = -1;
        String string = s;
        char[] chars = string.toCharArray();
        char c = '1';

        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();

        //使用LinkedHashMap把所有元素放入,并且要保持放入的顺序
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (hm.containsKey(chars[i])) {
                hm.put(chars[i], hm.get(chars[i]) + 1);
            } else {
                hm.put(chars[i], 1);
            }
        }

        Set set = hm.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Character ch = (Character) iterator.next();
            if (hm.get(ch) == 1) {
                c = ch;
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            if (c == chars[i]) {
                result = i;
                break;
            }
        }
        System.out.println(result);

        return result;
    }
}
