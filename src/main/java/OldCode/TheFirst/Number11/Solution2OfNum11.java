package OldCode.TheFirst.Number11;

public class Solution2OfNum11 {
    public static void main(String[] args){
        int [] height ={1,8,6,2,5,4,8,3,7};
        int max = 0;

        Solution2 solution2 =new Solution2();
        max = solution2.maxArea(height);
        System.out.println(max);
    }
}

class Solution2 {
    public int maxArea(int[] height) {
        int maxArea=0;
        int L=0,R=height.length-1;
        int temp=0;

        maxArea = (Math.min(height[R],height[L]))*(R-L);

        for (int i=0;i<height.length;i++){
            if (R != L){
                //
                if (height[L]<height[R]) {
                    L++;
                }else {
                    R--;
                }
                //算出目前的面积
                temp = (Math.min(height[R],height[L]))*(R-L);
                //如果目前的面积大于已经存在的maxRrea,就进行替换
                if (temp > maxArea) {
                    maxArea = temp;
                }
            }
        }

        return  maxArea;
    }
}