/**
 * @author liu
 * @time 2019 1 27
 * @内容
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
 */
public class Number2 {
    public static ListNode sumTwoNode = new ListNode();
    /**
     * @param l1
     * @param l2
     * @return  sumTwoNode
     * 内容: 处理ListNode的主程序
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode sumTwoNode = new ListNode();
        //把值放到sumTwoNodeInt 中,把反向取余数的值放到一个数组中
        int sumTwoNodeInt = 0;
        //int []a = new int [100];
        //把l1和l2的值转换为10进制的int
        int valueListNodeL1 = 0;
        int valueListNodeL2 = 0;

        valueListNodeL1 = getValueListNode(l1);
        valueListNodeL2 = getValueListNode(l2);
        System.out.println(valueListNodeL1+","+valueListNodeL2);

        //两个已经转换为int类型的数据相加,把和进行反向取余数,并且把余数放到listNode中
        sumTwoNodeInt= valueListNodeL1 + valueListNodeL2;
        System.out.println(sumTwoNodeInt);
        int length=getNumLenght(sumTwoNodeInt);
        int []a = new int [length];
        ListNode []b = new ListNode[length];
        for (int i =0;i<length;i++){
            //sumTwoNodeInt/10的多少次方%10  从10的0次方开始
            a[i]= (int) (sumTwoNodeInt/(Math.pow((double)10,(double)i))%10);
            //i+1<length的不等式成立表示有下一个,并且把next指向下一个
            if(i+1<length){
                b[i]=new ListNode(a[i]);
                b[i].setNext(b[i+1]);
                //b[i].setNext(b[i+1]);
                //b[i].setVal(a[i]);
            }else {
                b[i]=new ListNode(a[i]);
                b[i].setNext(null);
                //b[i].setNext(null);
                //b[i].setVal(a[i]);
            }
        }

        //循环输出a
        for (int i : a) {
            System.out.println(i);
        }

        return sumTwoNode;
    }

    /**
     * 取出一个数的位数
     * @param num
     * @return
     */
    private static int getNumLenght(long num){
        if (num==0) {
            return 1;
        }
        int lenght = 0;
        long temp =0;
        for (temp = num ; temp != 0; temp/=10){
            lenght++;
        }
        return lenght;
    }

    /**
     * @param lNode
     * @return sum
     * @version 1.0
     * 作用:把传入的ListNode转换为10进制的int
     */
    public static int getValueListNode(ListNode lNode){
        int sum = 0;
        //值=Val的10的多少次方 累加
        int i=0;
        if (lNode !=null){
            //设置两个指针,一个用于计算,一个用于指向下一个的地址并且进行判断是否为空
            do {
                ListNode lNode2 = lNode;
                sum+= lNode2.getVal() *(int)(Math.pow((double) 10,(double) i));
                lNode = lNode2.getNext();
                i++;
            }while (lNode!= null);
        }
        /**
        for (int i=0;true;i++){
            sum= lNode.getVal() *(int)(Math.pow((double) 10,(double) i));
            lNode = lNode.getNext();
            if (lNode.getNext() != null){
                break;
            }
        }   */
        return sum;
    }

    public static void main(String [] args){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
        l1.setNext(l12);
        l12.setNext(l13);

        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(3);
        ListNode l23 =new ListNode(5);
        l2.setNext(l22);
        l22.setNext(l23);

        addTwoNumbers(l1,l2);
    }

}

/**
 *
 * ListNode类
 * 提供了get和set方法
 */
class ListNode {
     private int val;
     private ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     ListNode(){
         val = 0;
         next = null;
     }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}