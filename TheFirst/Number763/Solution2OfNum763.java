package Number763;

import java.util.LinkedList;
import java.util.List;

public class Solution2OfNum763 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String S = "ababcbacadefegdehijhklij";

        //solution2.partitionLabels(S);
        System.out.println(solution2.partitionLabels(S));
    }

}

/**
 * 思路二:
 * 使用双指针
 *
 *所有的片段相加,要等价于原有的String S
 *
 *
 */
class Solution2 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new LinkedList<>();
        char [] charsForS =S.toCharArray();
        int L=0,R=charsForS.length-1;

        for (int i = 0; i < charsForS.length; i++) {
            //for (int j)
            if (charsForS[L] == charsForS[R]) {
                ((LinkedList<Integer>) result).addLast(R-L);
            }else {

            }
        }
        return result;
    }

    /**
     * 去除重复元素,重复多次的元素只取第一次出现
     *
     * 思路:
     * 把传入的字符串string转换为数组
     * 把数组的元素一个个慢慢的传入,然后进行判断
     * 判断传入的元素是不是为空格" ",如果为空格" ",直接跳过,开始下一个
     * 如果不为空,就把它放到res中,然后检查刚刚放入到元素在string的未检查部分是否还存在
     * 如果在未检查部分存在,就把未检查部分的相同元素设置为" "空格
     * 如果不为空,检查在已经经过检查的中是否有相同元素
     *
     * @param string
     * @return res
     */
    public String NoSomeString(String string){
        char[] charsForIn = string.toCharArray();
        String res = new String();



        return res;
    }
}
