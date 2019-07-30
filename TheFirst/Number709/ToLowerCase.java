package Number709;

/**
 * @author liu CMDEGR
 * @date 2019年1月31日 16:03:56
 * 内容:
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class ToLowerCase {
    public static String toLowerCase(String str) {
        String resultStr = "";
        str = str.toLowerCase();
        resultStr=str;

        return resultStr;
    }

    public static void main(String []args){
        System.out.println(toLowerCase("Hello"));
    }
}
