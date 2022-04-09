package TheFirst.Number345;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author liu
 * @version 1.0
 * @date 2019.4.11
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * 元音字母 有：a，e，i，o，u五个
 */
public class Solution1OfNum345 {
    public static void main(String[] args) {
        new Solution().reverseVowels("leetcode");
    }
}

class Solution {
    public String reverseVowels(String s) {
        String result = new String(" ");

        char[] chars = s.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();
        String str = new String("aeiouAEIOU");

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (str.contains(chars[i] + "")) {
                stringBuffer.append(chars[i]);
                arrayList.add(i);
            }
        }

        //System.out.println(stringBuffer);
        Iterator<Integer> iterator = arrayList.iterator();
        int place = 0;
        for (int i = stringBuffer.length()-1; iterator.hasNext(); i--) {
            //System.out.println(iterator.next());
            place = iterator.next();
            chars[place] = stringBuffer.charAt(i);
        }

        //result = chars.toString();
        result = String.valueOf(chars);
        System.out.println(result);
/*        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }*/

        return result;
    }
}
