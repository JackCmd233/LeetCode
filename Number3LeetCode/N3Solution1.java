package Number3LeetCode;

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
    public static String stringToString(String input) {
        String resultStr = "";

        if (input == null || input.equals(' ') || input.equals(" ")){
            return resultStr;
        }
        //把input一个个字符的传入到数组中
        int inputLength = input.length();
        char [] charsInput = new char[inputLength];

        //传入到数组中 使用string的char charAt(int index); 获取指定位置的字符
        for(int i=0;i<inputLength;i++){
            charsInput[i] = input.charAt(i);

        }

        //使用双重循环
        //外面两层循环是控制resultStr的长度(一个控制头,一个控制尾部),里面一层循环用于检验是否有重复字符
        for (int i =0;i<inputLength;i++){
         outer:for (int j=inputLength-1;j>=i;j++){
                //把假设的字符串放到temp中
                int tempLength = j-i+i;
                char[] temp = new char[tempLength];
                int point=0;
                int pointHead=i;
                int pointLast=j;
                do {
                    temp[point] = charsInput[pointHead];
                    pointHead++;
                }while (pointHead == pointLast);

                //检验字符内部是否存在相同的重复字符
                for (int a=0;a<tempLength;a++){
                    for (int b=a+1;b<tempLength;b++){
                        if(temp[a] == temp[b]){
                            continue outer;
                        }
                    }
                }

            }
        }
        return resultStr;
    }

    public static void main(String[] args){

    }
}
