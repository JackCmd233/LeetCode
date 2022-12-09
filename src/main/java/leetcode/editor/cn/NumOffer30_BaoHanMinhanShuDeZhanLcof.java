package leetcode.editor.cn;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 * <p>
 * Related Topics 栈 设计 👍 413 👎 0
 */


import java.util.Stack;

/**
 * 时间：2022-12-08 18:49:30
 * 题目编号：剑指 Offer 30
 * 题目标题：包含min函数的栈
 * TODO:: 不完全满足 时间复杂度都是O(1), 只能说是做出来了.
 */
public class NumOffer30_BaoHanMinhanShuDeZhanLcof {

    public static void main(String[] args) {
        //Solution solution = new Num剑指 Offer 30_BaoHanMinhanShuDeZhanLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        class Entity {
            /**
             * 当前值
             */
            private Integer localValue;
            /**
             * 整个栈的最小值
             */
            private Integer minValue;

            public Integer getLocalValue() {
                return localValue;
            }

            public void setLocalValue(Integer localValue) {
                this.localValue = localValue;
            }

            public Integer getMinValue() {
                return minValue;
            }

            public void setMinValue(Integer minValue) {
                this.minValue = minValue;
            }
        }

        /**
         * 数据保存的栈
         */
        private Stack<Entity> stack;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        /**
         * 压入栈
         *
         * @param x
         */
        public void push(int x) {
            Entity entity = new Entity();
            entity.setLocalValue(x);
            if (stack.isEmpty()) {
                //第一个压入的元素
                entity.setMinValue(x);
                stack.push(entity);
            } else {
                Entity temp = stack.get(0);
                if (temp.getMinValue() <= x) {
                    //压入的为 非最小值
                    entity.setMinValue(temp.getMinValue());
                    stack.push(entity);
                } else {
                    //压入的为 最小值
                    entity.setMinValue(x);
                    stack.push(entity);
                    for (int i = 0; i < stack.size(); i++) {
                        stack.get(i).setMinValue(x);
                    }
                }
            }

        }

        /**
         * 移出最顶层的元素
         */
        public void pop() {
            Entity pop = stack.pop();
            if (stack.isEmpty()) {
                return;
            }

            if (pop.getMinValue() >= pop.getLocalValue()) {
                //如果弹出的是最小值, 则需要重新选举最小值
                Integer minValue = stack.get(0).getLocalValue();
                for (Entity temp : stack) {
                    Integer localValue = temp.getLocalValue();
                    if (localValue < minValue) {
                        minValue = localValue;
                    }
                }

                //将最小值,设置到每一个元素上
                for (Entity entity : stack) {
                    entity.setMinValue(minValue);
                }
            }
        }

        /**
         * 获取最顶层的元素
         *
         * @return
         */
        public int top() {
            return stack.peek().getLocalValue();
        }

        /**
         * 获取最小值
         *
         * @return
         */
        public int min() {
            return stack.get(0).getMinValue();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
