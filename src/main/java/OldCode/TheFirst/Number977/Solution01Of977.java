package OldCode.TheFirst.Number977;

import java.util.Arrays;

public class Solution01Of977 {
    public static void main(String [] args){
        Solution solution = new Solution();
        int[] A = {-7,-3,2,3,11};
        solution.sortedSquares(A);

        for (int temp:A) {
            System.out.println(temp);
        }

    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return  A;
    }
}