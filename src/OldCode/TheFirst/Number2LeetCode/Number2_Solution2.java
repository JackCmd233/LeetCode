package OldCode.TheFirst.Number2LeetCode;

/**
 * @author liu CMDEGR
 * @version 1.0
 * 这是其他人提供的答案,可以通过
 */
public class Number2_Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //result为头指针,tailNode为尾指针
        ListNode result = null;
        ListNode tailNode = null;
        int sum = 0;
        int preAdd = 0;

        //首先要进行非空判断 ,然后才是进行运算
        while(true){
            if(l1 == null && l2 == null && preAdd == 0){
                return result;
            }
            if( l1 == null && l2 == null){
                tailNode.next = new ListNode(preAdd);
                return result;
            }else if(l2 == null){
                int temp = l1.val + preAdd;
                sum = temp % 10;
                preAdd = temp / 10;
                l1 = l1.next;
            }else if(l1 == null){
                int temp = l2.val + preAdd;
                sum = temp % 10;
                preAdd = temp / 10;
                l2 = l2.next;
            }else{
                //preAdd存储要进一位的值   sum存储对应节点的值
                int temp = l1.val + l2.val + preAdd;
                sum = temp % 10;
                preAdd = temp / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(result == null){
                result = new ListNode(sum);
                tailNode = result;
            }else{
                tailNode.next = new ListNode(sum);
                tailNode = tailNode.next;
            }
        }
    }
}
