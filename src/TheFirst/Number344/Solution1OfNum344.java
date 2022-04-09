package TheFirst.Number344;

public class Solution1OfNum344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Solution solution = new Solution();
        solution.reverseString(s);
    }
}

class Solution {
    public void reverseString(char[] s) {
        char temp ;
        int L = 0, R = s.length - 1;

        for (int i = 0; i < s.length; i++) {
            if (L != R && L<= R) {
                temp = s[L];
                s[L] = s[R];
                s[R] = temp;
                L++;
                R--;
            }
        }

    }
}
