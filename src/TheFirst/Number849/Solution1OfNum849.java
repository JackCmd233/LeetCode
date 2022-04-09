package TheFirst.Number849;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author liu
 * <p>
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * 至少有一个空座位，且至少有一人坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * <p>
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 */
public class Solution1OfNum849 {
    public static void main(String[] args) {
        int[] seats = {0, 0, 1, 0, 1, 1};
        System.out.println(new Solution().maxDistToClosest(seats));
    }
}

/**
 * 遍历数组
 * 三个不同的变量进行比较即可:
 * 第一个变量: 最左端的0位置 ,与最近变量的距离
 * 第二个变量: 最右端的n位置 , 与最近变量的距离
 * 第三个变量: 最长线段, 与位置的距离
 * 找到这三个不同变量的最大值,获取其位置
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int result = 0;
        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                //获取所有坐了人的位置信息
                arrayList.add(i);
            }
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //获取最左端,和最右端
        int left, right;
        int tempL = arrayList.get(0) - 0;
        int tempR = (seats.length - 1) - arrayList.get(arrayList.size() - 1);
        if (tempL > 0) {
            left = tempL;
        } else {
            left = 0;
        }

        if (tempR > 0) {
            right = tempR;
        } else {
            right = 0;
        }
        System.out.println(left+" "+right);

        //最长的段落
        int max = 0;
        int maxLengthSeats = 0;
        int maxL = 0, maxR = 0;
        int temp = 0;

        for (int i = 0; i < arrayList.size() - 1; i++) {
            temp = arrayList.get(i + 1) - arrayList.get(i);
            if (temp > maxLengthSeats) {
                maxLengthSeats = temp;
                maxL = arrayList.get(i);
                maxR = arrayList.get(i + 1);
            }
        }
        max = (maxL + maxR) / 2;
        System.out.println("maxL:" + maxL + " " + "maxR:" + maxR + " " + "max:" + max);
        maxLengthSeats = max - maxL;

        if (left > right && left > maxLengthSeats) {
            result = left;
        } else if (right > left && right > maxLengthSeats) {
            result = right;
        } else {
            result = maxLengthSeats;
        }

        return result;
    }
}
