package leetcode.editor.cn;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 356 👎 0
 */


/**
 * 时间：2022-12-09 18:09:52
 * 题目编号：剑指 Offer 06
 * 题目标题：从尾到头打印链表
 */
public class NumOffer06_CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new NumOffer06_CongWeiDaoTouDaYinLianBiaoLcof.Solution();
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);

        int[] ints = solution.reversePrint(head);
        System.out.println(ints);

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
//    static class Solution {
    //使用辅助栈, 完成
//        public int[] reversePrint(ListNode head) {
//            Stack<Integer> stack = new Stack<>();
//            int[] result = {};
//            if (head == null) {
//                return result;
//            }
//            int val = head.val;
//            ListNode nextNode = head.next;
//            stack.push(val);
//            //压栈
//            while (nextNode != null) {
//                val = nextNode.val;
//                stack.push(val);
//                if (nextNode.next != null) {
//                    nextNode = nextNode.next;
//                } else {
//                    break;
//                }
//            }
//
//            //将栈转换为数组
//            int size = stack.size();
//            result = new int[size];
//            for (int i = 0; i < size; i++) {
//                Integer pop = stack.pop();
//                result[i] = pop;
//            }
//
//            return result;
//        }
//    }
//


    /**
     * 使用递归解决
     */
    static class Solution {
        int[] res;
        int i = 0;
        int j = 0;

        public int[] reversePrint(ListNode head) {
            solve(head);
            return res;
        }

        public void solve(ListNode head) {
            if (head == null) {
                res = new int[i];
                return;
            }
            i++;
            solve(head.next);
            res[j] = head.val;
            j++;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
