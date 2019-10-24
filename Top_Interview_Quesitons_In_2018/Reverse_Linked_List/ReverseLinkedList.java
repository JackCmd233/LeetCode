package Top_Interview_Quesitons_In_2018.Reverse_Linked_List;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        System.out.println(node1);

        ListNode result = new Solution().reverseList(node1);

        System.out.println("  " + result);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1149/
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
class Solution {
    //把反转之后的结果一个个存入到static中
    private static ListNode result = null;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        //需要把静态变量置为Null, 防止下次在调用的时候,发生原来的值没有去除
        result = null;
        reverseListSolution(head);
        return head;
    }


    public void reverseListSolution(ListNode head) {
        //把反转之后的结果一个个存入到static中
        int value = head.val;
        ListNode node = new ListNode(value);

        if (head.next != null) {
            node.next = result;
            result = node;
            reverseListSolution(head.next);
        } else {
            node.next = result;
            result = node;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}