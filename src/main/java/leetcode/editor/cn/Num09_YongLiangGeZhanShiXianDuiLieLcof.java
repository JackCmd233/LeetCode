package leetcode.editor.cn;

//<p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>
//[&quot;CQueue&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
//[[],[3],[],[]]
//<strong>输出：</strong>[null,null,3,-1]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>
//[&quot;CQueue&quot;,&quot;deleteHead&quot;,&quot;appendTail&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
//[[],[],[5],[2],[],[]]
//<strong>输出：</strong>[null,-1,null,null,5,2]
//</pre>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= values &lt;= 10000</code></li>
//	<li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 504</li><li>👎 0</li></div>


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 时间：2022-04-09 22:42:53
 * 题目编号：剑指 Offer 09
 * 题目标题：用两个栈实现队列
 */
public class Num09_YongLiangGeZhanShiXianDuiLieLcof {

    public static void main(String[] args) {
        CQueue solution = new Num09_YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        // TO TEST
        solution.appendTail(3);
        //System.out.println(solution.queue.toString());
        System.out.println(solution.deleteHead());
        //System.out.println(solution.queue.toString());
        System.out.println(solution.deleteHead());
        //System.out.println(solution.queue.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //第一种解法：使用List
//    class CQueue {
//        private List<Integer> queue;
//
//        public CQueue() {
//            queue = new ArrayList<>();
//        }
//
//        /**
//         * 队列尾部插入整数
//         *
//         * @param value
//         */
//        public void appendTail(int value) {
//            queue.add(value);
//        }
//
//        /**
//         * 队列头部删除整数
//         *
//         * @return
//         */
//        public int deleteHead() {
//            if (queue.size() == 0) {
//                return -1;
//            } else {
//                return queue.remove(0);
//            }
//        }
//    }


    //第二种: 使用stack
//    class CQueue {
//        private Stack<Integer> queue;
//
//        public CQueue() {
//            queue = new Stack<>();
//        }
//
//        /**
//         * 队列尾部插入整数
//         *
//         * @param value
//         */
//        public void appendTail(int value) {
//            queue.push(value);
//
//        }
//
//        /**
//         * 队列头部删除整数
//         *
//         * @return
//         */
//        public int deleteHead() {
//            if (queue.isEmpty()) {
//                return -1;
//            } else {
//                return queue.remove(0);
//            }
//
//        }
//    }
//

    //第三种: 真正意义上的用用两个队列实现
    class CQueue {
        private Stack<Integer> queue1;
        private Stack<Integer> queue2;

        public CQueue() {
            queue1 = new Stack<>();
            queue2 = new Stack<>();
        }

        /**
         * 队列尾部插入整数
         *
         * @param value
         */
        public void appendTail(int value) {
            queue1.push(value);

        }

        /**
         * 队列头部删除整数
         *
         * @return
         */
        public int deleteHead() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return -1;
            }

            //只要输出流有数据， 就优先把输出流的数据处理
            if (!queue2.isEmpty()) {
                return queue2.pop();
            }

            //当输出流没有数据时 才去压入输入流的数据
            while (!queue1.isEmpty()) {
                queue2.push(queue1.pop());
            }
            return queue2.pop();

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


