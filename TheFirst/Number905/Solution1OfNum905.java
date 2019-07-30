package Number905;

public class Solution1OfNum905 {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4};
        int[] result = new int[A.length];
        Solution solution = new Solution();
        result = solution.sortArrayByParity(A);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        //int point = 0;


        for (int i = 0, Lpoint = 0, Rpoint = A.length - 1; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[Lpoint] = A[i];
                Lpoint++;
                System.out.println(A[i] + "===========");
            } else {
                result[Rpoint] = A[i];
                Rpoint--;
                System.out.println(A[i] + "=====");
            }
        }

        return result;
    }
}
