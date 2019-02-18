package Number763;

import java.util.LinkedList;
import java.util.List;

//该思路未能成功

/**
 * @author liu
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在
 * 其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 题目要求:
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class Solution1OfNum763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();

        System.out.println(solution.NonSameString(str));
        solution.partitionLabels(str);
        System.out.println( solution.partitionLabels(str));
    }
}

/**
 * 思考:
 * 为了保证划分的片段数较多,必须尽量让每一个片段的长度短
 * <p>
 * 解题思路:
 * 第一步:把String转换为字符串
 * 第二步:把最短的片段放进去(也就是第一个字符),循环检查是否放进去的字符在其他地方有出现
 * 第三步:如果在其他地方有出现,则把最短片段扩大一个字符(也就是前两个字符),循环检查是否放进去的字符在其他地方有出现
 * 第四步:反复循环,保证片段短,但是不会出现在其他地方,每成功一次就把长度放到List中
 * 第五步:下一次的检查为最短片段的开始处
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new LinkedList<>();
        char[] tempChar = new char[S.length()];
        String temp = new String();
        String tempLost = new String();

        //第一步
        char[] chars = S.toCharArray();

        //第二步放入最短片段
        for (int i = 0; i <= chars.length; i++) {
            for (int j = i+1; j <= chars.length; j++) {
                temp = S.substring(i, j);
                tempLost = S.substring(j, chars.length);
                //System.out.println(temp);
                //System.out.println(tempLost);
                //System.out.println("----------------------------------");
                //第二步,第二点判断放进去的字符在其他对方是否出现
                // 最简单的方法暴力法,把temp中所有的字符都进行一次检查
                //或者选择temp中出现过的字符,检查一遍
                tempChar = NonSameString(temp).toCharArray();
                //选择在temp中出现过的字符
                for (int z = 0; z < tempChar.length; z++) {
                    if (tempLost.contains(tempChar[z]+"")){
                        break;
                    }else if (z == tempChar.length-1){
                            ((LinkedList<Integer>) result).addLast(temp.length());
                    }
                }
            }
            //System.out.println("=====================================");
        }


        return result;
    }

    /**
     * 字符串中出现过的字符返回
     * @param str
     * @return
     */
    String NonSameString(String str) {
        int len = str.length();
        char[] charsForString = str.toCharArray();
        if (len < 2) {
            //字符串长度为0或者为1直接返回该字符串即可
            return str;
        }
        String res = "";
        for (int i = 0; i < len; i++) {
            if (charsForString[i] != ' ') {
                res += charsForString[i];
                //res只存放不是空格且不重复的字符
                for (int j = i + 1; j < len; j++) {
                    if (charsForString[j] == charsForString[i]) {
                        //与前面字符重复的直接用空格替换
                        charsForString[j] = ' ';
                    }
                }
            }

        }
        return res;
    }

}
