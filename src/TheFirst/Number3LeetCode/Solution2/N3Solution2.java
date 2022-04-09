package TheFirst.Number3LeetCode.Solution2;

/**
 * @author liu CMDEGR
 * @version 2.0
 * 说明:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class N3Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int resultLength =0;
        String longestString = "";

        //把input一个个字符的传入到数组中
        int inputLength = s.length();
        System.out.println("input长度:"+inputLength);
        char [] charsInput = new char[inputLength];

        //传入到数组中 使用string的char charAt(int index); 获取指定位置的字符
        for(int i=0;i<inputLength;i++){
            charsInput[i] = s.charAt(i);
            System.out.println(charsInput[i]);
        }

        //输出,子串数组`

        longestString = String.valueOf(charsInput);
        System.out.println("input字符串数组:"+longestString);

        //使用双重循环
        //外面两层循环是控制resultStr的长度(一个控制头,一个控制尾部),里面一层循环用于检验是否有重复字符(里面有一个判断语句,用于判断是否是最长的子串)
        outer1:
        for (int i = 0;i<inputLength;i++){
            outer2:
            for (int j=inputLength-1;j>=i;j--){
                System.out.println("i:"+i+' '+"j"+j);
                System.out.println("开始检查是否有重复字符");
                //把假设的字符串放到temp中
                int tempLength = j-i+1;
                char[] temp = new char[tempLength];
                for (int z=0;z<tempLength;z++){
                    temp[z]= ' ';
                }
                int point = 0;
                int pointHead=i;
                int pointLast=j;
                do {
                    System.out.println("字符填入");
                    temp[point] = charsInput[pointHead];
                    System.out.println("pointHead:"+pointHead+","+"pointLast:"+pointLast);
                    pointHead++;
                    point++;
                }while (pointHead <= pointLast);

                //检查字符是否填入
                String tempStr = String.valueOf(temp);
                System.out.println("输出tempStr字符"+tempStr);

                //检验字符内部是否存在相同的重复字符
                inner:
                for (int a=0;a<tempLength;a++){
                    for (int b=a+1;b<tempLength;b++){
                        if(temp[a] == temp[b]){
                            System.out.println("存在重复字符:"+temp[a]);
                            System.out.println("跳出检查,开始下一个目标的检查");
                            System.out.println("------------------------------------");
                            //break inner;
                            continue outer2;
                        }else{
                            ;
                        }
                    }
                }

                //经过检查步骤的子串通过了,就把他复制给resultStr,并且直接返回结果

                //resultStr = new String(temp);
                longestString = String.valueOf(temp);
                System.out.println("输出最后一个字符"+temp[tempLength-1]);
                System.out.println("输出完整字符"+longestString);

                if(resultLength <= tempLength){
                    resultLength = longestString.length();
                    System.out.println("长度是:"+resultLength);
                }

                System.out.println("输出resultStr字符"+longestString);
                System.out.println("****************");
               // break outer1;
            }
        }

        resultLength = longestString.length();
        return  resultLength;
    }

    public static void main(String [] args){
        int length =lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }
}
