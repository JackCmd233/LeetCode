package TheFirst.Number1LeetCode;
/**
 * @author keriezhang
 * @date 2019/1/27
 * @version 1.0
 * 内容:
     *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
 */
public class Number1Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int num1=-2,num2=-1;
        for (int i =0 ;i<nums.length;i++){
            int temp =0;
            temp = target - nums[i];
            for (int j=i +1;j<nums.length;j++){
                if (nums[j] == temp){
                    num1=i;
                    num2=j;
                }else {
                    ;
                }
            }
        }
        int []resoultNum = {num1,num2};
        return  resoultNum;
    }

    public static void main(String [] args){
        int[] resoult;
        int[] nums={2, 7, 11, 15};
        resoult = twoSum(nums, 9);

        System.out.print(resoult[0]+","+resoult[1]);
    }
}
