package TheFirst.Number4;

import java.util.Arrays;

public class Solution1OfNumber4 {
    public static void main(String [] args){
        int []nums1 ={1, 2};
        int []nums2 = {3,4};
        int newLength = nums1.length+nums2.length;
        double  result ;
        result = new Solution4().findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newLength = nums1.length+nums2.length;
        int [] result = new int[newLength];

        for (int i=0,j=0;i<newLength;i++) {
            if (i<nums1.length){
                result[i] = nums1[i];
            }else {
                result[i]=nums2[j];
                j++;
            }
        }

        Arrays.sort(result);

        if (newLength%2 == 0){
            return (result[newLength/2]+result[newLength/2-1])/2.0;
        }else {
            return result[newLength/2];
        }
    }
}