package Number15;

import java.util.*;

public class Solution1OfNum15 {
    public static void main(String[] args) {
        int nums[] = {13, -5, 3, 3, -1, 13, 3, 1, -9, -4, 9, 12, 6, -9, -6, -12, -8, 3, 12, 14, 4, -15, 2, -11, 4, -12, 10, 9, -6, -3, -8, 14, 7, 3, 2,
                -8, -7, -10, 8, -8, -7, -6, -11, 6, -7, -2, 9, -8, 8, -2, 13, -10, -2, 0, -14, -13, -4, 11, 3, -3, -7, 3, -4, 8, 13, 13, -15, -9, 10, 0, -2, -12, 1, 2, 9, 1, 8, -4, 8, -7, 9, 7, -2, -15, 14, 0, -13, -13, -12, -2, -1, -11, 8, 10, 12, 6, 8, 4, 12, 3, 11, -12, -2, -3, 5, -15, 6, -10, -4, -1, -1, -10, 13};
        List<List<Integer>> result;
        Solution solution = new Solution();
        result = solution.threeSum(nums);
        System.out.println(result);
    }
}

/**
 * @author liu CMDEGR
 * <p>
 * 解题步骤:
 * 第一步:排序(把正负数分开)
 * 第二步:把两个数相加为sum,如果第三个数与sum相加等于0
 * 第三步:把三个数都放在result中(注意去重复)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int temp = 0;
        List<Integer> tempNode = new LinkedList<>();
        //第一步
        Arrays.sort(nums);
/*        for (int temp1 : nums) {
            System.out.println(temp1 + ",");
        }*/

        //第二步
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                temp = nums[i] + nums[j];
                temp = 0 - temp;
                //System.out.println("temp:"+temp);
                for (int k = j + 1; k < nums.length; k++) {
                    if (temp == nums[k]) {
                        //List<Integer> tempNode = new LinkedList<>();
                        tempNode = new LinkedList<>();
                        System.out.println(nums[i] + "," + nums[j] + "," + nums[k] + ",");
                        ((LinkedList<Integer>) tempNode).addLast(nums[i]);
                        ((LinkedList<Integer>) tempNode).addLast(nums[j]);
                        ((LinkedList<Integer>) tempNode).addLast(nums[k]);

                        //检查是否有重复的Node
                        ListIterator listIterator = result.listIterator();
                        if (result.contains(tempNode)) {
                            System.out.println("已经存在相同节点");
                        } else {
                            ((LinkedList<List<Integer>>) result).addLast(tempNode);
                            System.out.println("节点存入");
                            System.out.println(nums[i] + "," + nums[j] + "," + nums[k] + ",");
                            System.out.println("------------------------------------");
                        }

                    }
                }
            }

        }
        return result;
    }
}