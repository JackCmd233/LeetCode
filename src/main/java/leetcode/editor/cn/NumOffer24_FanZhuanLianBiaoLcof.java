package leetcode.editor.cn;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * Related Topics 递归 链表 👍 514 👎 0
 */


import java.util.Stack;

/**
 * 时间：2022-12-15 10:33:14
 * 题目编号：剑指 Offer 24
 * 题目标题：反转链表
 */
public class NumOffer24_FanZhuanLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new NumOffer24_FanZhuanLianBiaoLcof.Solution();
        // TO TEST
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);

        ListNode listNode = solution.reverseList(head);
        int val = listNode.val;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     * int val;
//     * ListNode next;
//     * ListNode(int x) { val = x; }
//     * }
//     * 辅助栈解法
//     */
//    static class Solution {
//        public ListNode reverseList(ListNode head) {
//            //辅助栈
//            Stack<ListNode> stack = new Stack<>();
//            //返回值
//            ListNode result = new ListNode(0);
//            if (head == null || head.next == null) {
//                //只有一个元素, 或者没有任何元素 直接返回
//                return head;
//            }
//
//            //stack.push(head);
//            ListNode nextNode = head;
//            while (nextNode != null) {
//                ListNode temp = nextNode.next;
//                //不需要指针了
//                nextNode.next = null;
//                //压栈
//                stack.push(nextNode);
//                nextNode = temp;
//            }
//
//            int size = stack.size();
//            //lastNode总是指向最后一个节点
//            ListNode lastNode = null;
//            for (int i = 0; i < size; i++) {
//                ListNode pop = stack.pop();
//
//                if (i == 0) {
//                    result = pop;
//                    lastNode = pop;
//                    result.next = null;
//                } else {
//                    lastNode.next = pop;
//                    lastNode = pop;
//                }
//            }
//
//            return result;
//        }
//
//    }

//    static class Solution {
//        /**
//         * 递归法
//         *
//         * @param head
//         * @return
//         */
//        public ListNode reverseList(ListNode head) {
//            Recursion(head);
//            return result;
//        }
//
//
//        ListNode result;
//
//        public ListNode Recursion(ListNode localNode) {
//            if (localNode == null || localNode.next == null) {
//                result = localNode;
//                return localNode;
//            }
//
//            ListNode fatherNode = Recursion(localNode.next);
//            fatherNode.next = localNode;
//            localNode.next = null;
//            return localNode;
//        }
//    }

    static class Solution {
        /**
         * 迭代(双指针)
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode before = null;
            ListNode current = head;

            while (current != null) {
                ListNode temp = current.next; //暂存下一个节点
                //修改指针指向
                current.next = before;
                before = current;
                current = temp;
            }
            return before;
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


