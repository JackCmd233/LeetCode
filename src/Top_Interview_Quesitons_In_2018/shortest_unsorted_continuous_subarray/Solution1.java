package Top_Interview_Quesitons_In_2018.shortest_unsorted_continuous_subarray;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int i = new Solution().findUnsortedSubarray(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        int[] temp = nums.clone();

        Arrays.sort(temp);

        if (Arrays.equals(nums, temp)) {
            return 0;
        }


        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != nums[i]) {
                left = i;
                break;
            }
        }


        for (int i = nums.length - 1; i >= 0; i--) {
            if (temp[i] != nums[i]) {
                right = i;
                break;
            }
        }
        System.out.println(right + "  " + left);

        result = right - left + 1;


        return result;
    }
}