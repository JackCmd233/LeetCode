package Number804;

import java.util.LinkedList;
import java.util.List;

public class Solution1OfNum804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution solution = new Solution();
        solution.uniqueMorseRepresentations(words);
    }

}

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int result = 0;
        List<List<String>> lists = new LinkedList<>();
        //暂存的节点
        List<String> tempNode = new LinkedList<>();
        //暂存的字符串
        String tempString = "";

        String[] Morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        //englistToMorse数组是摩尔斯与英语字母的对应关系
        String[][] englistToMorse = new String[Morse.length][2];
        String english = "abcdefghijklmnopqrstuvwxyz";
        char[] englishWords = english.toCharArray();

        //存储传入的单词
        char[] wordsTemp = new char[12];

        for (int i = 0; i < Morse.length; i++) {
            englistToMorse[i][0] = Morse[i];
            englistToMorse[i][1] = String.valueOf(englishWords[i]);
        }

        for (int i = 0; i < words.length; i++) {
            //对传入的单词进行循环
            wordsTemp = words[i].toCharArray();
            //对tempNode和tempString进行清空
            tempNode = new LinkedList<>();
            tempString = "";
            for (int j = 0; j < wordsTemp.length; j++) {
                //对传入的单词的每个字母进行处理
                for (int z = 0; z < englistToMorse.length; z++) {
                    //把字母与Morse对应
                    if (String.valueOf(wordsTemp[j]).equals(englistToMorse[z][1])) {
                        //System.out.println(englistToMorse[z][0]);
                        //tempNode.add(englistToMorse[z][0]);
                        tempString += englistToMorse[z][0];
                        break;
                    }
                }
            }
            //把摩尔斯字符串存入到tempNode中
            System.out.println(tempString);
            ((LinkedList<String>) tempNode).add(tempString);
            if (lists.contains(tempNode)) {
                //如果有相同的节点,就继续循环,该单词的摩尔斯字符串不添加到链表中
                continue;
            } else {
                ((LinkedList<List<String>>) lists).add(tempNode);
                System.out.println("这是lists的对应情况" + lists);
                System.out.println("================");
            }
        }

        System.out.println("-------------------------------");
        System.out.println(lists);

        result = lists.size();
        System.out.println(result);
        return result;
    }
}

