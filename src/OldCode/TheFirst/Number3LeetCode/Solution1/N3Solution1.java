package OldCode.TheFirst.Number3LeetCode.Solution1;

/**
 * @author liu CMDEGR
 * @version 1.0
 * 要求:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class N3Solution1 {
    static String stringToString(String input) {
        String resultStr = "此处为空";

//        if (input.equals(null)||input.equals("")){
//            return resultStr;
//        }
        //把input一个个字符的传入到数组中
        int inputLength = input.length();
        System.out.println("input长度:"+inputLength);
        char [] charsInput = new char[inputLength];

        //传入到数组中 使用string的char charAt(int index); 获取指定位置的字符
        for(int i=0;i<inputLength;i++){
            charsInput[i] = input.charAt(i);
            System.out.println(charsInput[i]);
        }

        //使用双重循环
        //外面两层循环是控制resultStr的长度(一个控制头,一个控制尾部),里面一层循环用于检验是否有重复字符
    outer1:
        for (int i = 0;i<inputLength;i++){
    outer2:
            for (int j=inputLength-1;j>=i;j--){
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
                                 //break inner;
                                continue outer2;
                            }else{
                                ;
                            }
                     }
                 }
                //经过检查步骤的子串通过了,就把他复制给resultStr,并且直接返回结果
                System.out.println("输出最后一个字符"+temp[tempLength-1]);
                //resultStr = new String(temp);
                resultStr = String.valueOf(temp);
                System.out.println("输出resultStr字符"+resultStr);
                System.out.println("****************");
                break outer1;
            }
        }
        return resultStr;
    }

    public static void main(String[] args){
        String strRs = stringToString("pwwkew");
        System.out.println("main函数结果:"+strRs);
    }
}
