package TheSecond.Number79;

public class Number79Of2 {

    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        //遍历数组, 找到board数组中与 word[0]字符相同的所有 位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        //如果所有字符都已经找到了
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        //在指定位置存在 与  word的第start个字符 相等
        if (board[i][j] == word.charAt(start)) {
            //假设当前路径时正确的, 则已经被访问了, 下次不能在使用了
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                //上 右 下 左 没有越界, 而且没有被访问过
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    //递归
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //如果当前路径错误, 我们必须把前面已经被访问的恢复
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        Number79Of2 solution = new Number79Of2();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}

