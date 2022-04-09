package Top_Interview_Quesitons_In_2018.VerifyThePalindrome;

public class VerifyThePalindrome {
    public static void main(String[] args) {
        boolean b = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(b);
    }
}

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
class Solution {
    public boolean isPalindrome(String s) {
        boolean result = false;




        s = s.toLowerCase();
        s = s.replaceAll("\\s*", "");
        s = s.replaceAll("[\\pP\\p{Punct}]", "");
        //System.out.println(s);
        char[] chars = s.toCharArray();

        if (chars.length<=1) {
            return true;
        }

        //System.out.println(chars.length-1);
        for (int i = 0; i < chars.length; i++) {
            int place = chars.length-1-i;
            if (chars[i] == chars[place] && i <= place) {
                //System.out.println(chars[i]+" "+i+" ; "+chars[place]+" "+place);
                result = true;
                continue;
            } else if (chars[i] != chars[place]){
                //System.out.println(chars[i]+" "+i+" ; "+chars[place]+" "+place);
                result = false;
                break;
            }
        }


        return result;
    }
}
