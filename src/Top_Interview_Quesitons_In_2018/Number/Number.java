package Top_Interview_Quesitons_In_2018.Number;

import java.util.*;

/**
 * @author liu
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Number {
    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int result=-1;
        double size = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Set set = map.keySet();
        Iterator iterator = set.iterator();

        Integer temp=-1;
        while (iterator.hasNext()) {
            temp = (Integer) iterator.next();
            if (map.get(temp) > size) {
                result = temp;
            }
        }
        System.out.println(result);

        return result;
    }
}
