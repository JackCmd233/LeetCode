package Number2LeetCode;
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
    /**
     * @param l1
     * @param l2
     * @return  sumTwoNode
     * 内容: 处理ListNode的主程序
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //第一步:处理传入的l1和l2
        //把值转换为10进制
        int valueListNode1 =getValueListNode(l1);
        int valueListNode2 =getValueListNode(l2);
        //求和
        int sumList1AndList2 = valueListNode1+valueListNode2;
        System.out.println("十进制位"+sumList1AndList2);

        //第二步:把两者的和sumList1AndList2 转换为个位 ,十位 ,百位,千位 .....的形式
        //获取sumList1AndList2的位数,新链表的长度就是sumList1AndList2的位数
        int lengthSum = getNumLenght(sumList1AndList2);
        System.out.println("有"+lengthSum+"位");
        //设置一个int数组,把sumList1AndList2的个位,十位,百位,千位的值,一一存入
        int [] sumList1AndList2_Int = new int[lengthSum];
        for (int i =0;i<lengthSum;i++){
            //原义(int) (sumList1AndList2/(Math.pow((double)10,(double)i))%10);
            sumList1AndList2_Int[i]=(int) (sumList1AndList2/(Math.pow((double)10,(double)i))%10);
            System.out.println("第"+i+"位:"+sumList1AndList2_Int[i]);
        }


        //第三步:创建一个List用于存储新的链表
        //根据新链表的长度,设置新链表
        //这样只不过是创建了lengthSum个ListNode的引用类型,并且全都指向NULL,不能使用get和set方法
        ListNode []listNodes=new ListNode[lengthSum];
        for (int i=0;i<lengthSum;i++){
            listNodes[i]=new ListNode();
        }

        //第四步:把的到的个位放到第一个节点 ,十位放到第二个节点,百位放到第三个节点,.....
        for (int i=0;i<lengthSum;i++){
            System.out.println(listNodes[0]);
            System.out.println("-------------");
            listNodes[i].setVal(sumList1AndList2_Int[i]);
            System.out.println("存入的数字"+listNodes[i].getVal());
            //如果有下一个就把next指向下一个
            if(i+1<lengthSum){
                listNodes[i].setNext(listNodes[i+1]);
            }
        }

        //第五步:尝试通过获取头结点到的十进制
        System.out.println(getValueListNode(listNodes[0]));
        return listNodes[0];
    }

    /**
     * 创建一个ListNode
     * @param num ,firstNode
     * @return
     */
    private static ListNode[] createListNode(int num,ListNode firstNode){
        //创建一个ListNode,长度根据传入的num决定,第一个是传入的firstNode
        ListNode[] headNode = new ListNode[num];
        headNode[0] = firstNode;

        //创建两个指针
        ListNode point1=headNode[0];
        ListNode point2=point1;

        return headNode;
    }

    /**
     * 取出一个数的位数长度
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
        return sum;
    }

    public static void main(String [] args){
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
      //  ListNode l13 = new ListNode(1);
        l1.setNext(l12);
       // l12.setNext(l13);

      //  ListNode l2 = new ListNode(1);
        ListNode l2=null ;
      //  ListNode l22 = new ListNode(1);
       // ListNode l23 =new ListNode(2);
       // l2.setNext(l22);
       // l22.setNext(l23);

        ListNode sum =new ListNode();

        sum = addTwoNumbers(l1,l2);
        System.out.println(getValueListNode(sum));

        //int sumInt = getValueListNode(addTwoNumbers(l1,l2));
        //System.out.println(sumInt);

    }

}

/**
 *
 * ListNode类
 * 提供了get和set方法
 */
class ListNode {
     int val;
     ListNode next;
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