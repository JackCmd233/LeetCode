package Number929LeetCode;

/**
 * @author liu CMDEGR
 * @date 2019年1月31日 11:47:26
 * 内容
 * 某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。
 * 本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
 *
 * 示例：
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *
 * 提示：
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 */
public class UniqueEmailAddresses {
    //第一步判断是否是邮件,根据有没有@字符判断
    //第二步去掉"+"和"."
    //第三步计算数量

    public static int numUniqueEmails(String[] emails) {
        int resultNum = 0;
        //int [] Num = new int[100];
        int amountEmail =0;


        //第一步,最好方法是使用正则表达式
        //这里是使用contains判断是email

        for (int i=0;i< emails.length;i++){
            if (emails[i].contains("@")){
                amountEmail++;
                resultNum++;
                System.out.println(emails[i]);
            }else {
                emails[i]=null;
            }
        }
        System.out.println(amountEmail);

        //第二步,去掉"+"和"."
        //首先去掉".",使用replace
        System.out.println("去掉.");
        for (int i=0;i<emails.length;i++){
            if (emails[i] == null){
                continue;
            }else {
                //去除 "."
                //保存@符号后面字段
                int restI = emails[i].indexOf('@');
                String rest = emails[i].substring(restI);
                //把所有的"."去掉
                emails[i] = emails[i].replace(".","");
                emails[i] = emails[i].substring(0, emails[i].indexOf('@'));
                emails[i] +=rest;
                System.out.println(emails[i]);
            }
        }


        //去掉+
        System.out.println("去掉+");
        for (int i=0;i<emails.length;i++){
            if (emails[i] == null){
                continue;
            }else if (emails[i].contains("+")){
                //去除 "+"
                int restI = emails[i].indexOf('@');
                String rest = emails[i].substring(restI);
                emails[i] = emails[i].substring(0, emails[i].indexOf('+'));
                emails[i] +=rest;
                System.out.println(emails[i]);
            }else {
                ;
            }
        }


        for (int i=0;i<emails.length;i++){
            for (int j=i+1;j<emails.length;j++){
                if(emails[i] != null && emails[j]!=null){
                    if (emails[i].equals( emails[j])) {
                        // 重复，数组总长度减1
                        resultNum--;
                        break;
                    }
                }
            }
        }

        return resultNum;
    }

    public static void main(String  []args){
        String [] emails ={"test.email+alex@leetcode.com","1231321321","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int sysNum = numUniqueEmails(emails);
        System.out.println(sysNum);
    }
}
