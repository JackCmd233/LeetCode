package TheFirst.Number11;

public class Solution1OfNum11 {
    public static void main(String[] args){
        Solution solution = new Solution();

        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println( solution.maxArea(height));
    }
}

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入数组 [1,8,6,2,5,4,8,3,7]
 * 表示:数组中的a(i)表示点(i+1,a(i))
 *
 *
 * 解题:
 * 什么是容纳最多的水:面积最大(选取的两条线与X轴,最低线,组成的矩形面积最大)
 * 如何确保面积最大:做一个双重循环,内循环的循环体为算出面积,如果面积比max(已知最大面积)还大,就把算出的面积放到max中
 * 把两条线放到
 *
 *
 */
class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int tallOfMostWater = 0;
        int widthOfMostWater =0;
        int size = 0;

        for (int i=0;i<height.length;i++){
            for (int j = i + 1; j < height.length; j++) {
                //矩形的高
                if (height[i] >= height[j]){
                    tallOfMostWater = height[j];
                }else {
                    tallOfMostWater = height[i];
                }

                //矩形的宽
                widthOfMostWater = j-i;
                //矩形的面积
                size = tallOfMostWater*widthOfMostWater;
                //如果面积比已知的最大面积还大,就取代max
                if (size > max){
                    max = size;
                }
            }
        }

        return max;
    }
}
