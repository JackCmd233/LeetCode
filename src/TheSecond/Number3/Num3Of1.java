package TheSecond.Number3;

import java.util.LinkedList;

/**
 * @author liu
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Num3Of1 {
    public static void main(String[] args) {
        String str = new String("pwwkew");
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int maxLength=0;
        char[] chars = s.toCharArray();

        LinkedList list = new LinkedList();
        int index=0;
        char temp;

        for (int i = 0; i < chars.length; i++) {
            temp = chars[i];
            if (list.contains(temp)) {
                index = list.indexOf(temp);
                poll(index, list);
            }
            list.add(temp);
            maxLength = list.size();
            if (maxLength >= result) {
                result = maxLength;
            }
            System.out.println(list);
            System.out.println("==========");
        }


        return result;
    }

    public void poll(int index, LinkedList list) {
        for (int i = 0; i <= index; i++) {
            list.poll();
        }
    }
}