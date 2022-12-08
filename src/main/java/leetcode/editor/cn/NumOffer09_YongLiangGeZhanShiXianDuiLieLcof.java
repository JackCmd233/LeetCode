package leetcode.editor.cn;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能
 * 。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * <p>
 * Related Topics 栈 设计 队列 👍 634 👎 0
 */


import java.util.Stack;

/**
 * 时间：2022-12-08 15:46:23
 * 题目编号：剑指 Offer 09
 * 题目标题：用两个栈实现队列
 */
public class NumOffer09_YongLiangGeZhanShiXianDuiLieLcof {

    public static void main(String[] args) {
        //Solution solution = new Num剑指 Offer 09_YongLiangGeZhanShiXianDuiLieLcof().new Solution();
        // TO TEST
        CQueue cQueue = new CQueue();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class CQueue {
        private Stack<Integer> stackInput;
        private Stack<Integer> stackOut;

        public CQueue() {
            stackInput = new Stack<>();
            stackOut = new Stack<>();
        }

        /**
         * 插入整数
         *
         * @param value
         */
        public void appendTail(int value) {
            stackInput.push(value);
        }

        /**
         * 头部删除整数
         *
         * @return
         */
        public int deleteHead() {
            if (stackInput.empty() && stackOut.empty()) {
                //队列为空
                return -1;
            }

            if (!stackOut.empty()) {
                //输出栈 不为空
                return stackOut.pop();
            } else {
                //输出栈为空, 则尝试从 输入栈倒入 输出站
                while (!stackInput.empty()) {
                    Integer popValue = stackInput.pop();
                    stackOut.push(popValue);
                }
                return stackOut.pop();
            }

            //return -1;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
