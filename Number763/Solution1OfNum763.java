package Number763;

import java.util.LinkedList;
import java.util.List;

public class Solution1OfNum763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        solution.partitionLabels(str);
    }
}

/**
 * 思考:
 * 为了保证划分的片段数较多,必须尽量让每一个片段的长度短
 *
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

        //第一步
        char [] chars= S.toCharArray();
/*        for (char temp: chars) {
            System.out.println(temp);
        }*/



        return result;
    }
}
