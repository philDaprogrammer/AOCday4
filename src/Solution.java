import java.util.ArrayList;


public class Solution {
    private final ArrayList<Integer> numbers;
    private final ArrayList<int[][]> boards;

    public Solution(ArrayList<Integer> numbers, ArrayList<int[][]> boards) {
        this.numbers = numbers;
        this.boards  = boards;
    }

    public void solveP1() {
         for (Integer number : this.numbers) {
             for (int[][] board : this.boards) {
                 int[] recentlyUpdated = updateBoard(board, number);

                 if (has5(board, recentlyUpdated)) {
                     dumpSol(board, number);
                     return;
                 }
             }
         }
    }

    public void solveP2() {
        for (Integer number : this.numbers) {
            ArrayList<int[][]> boards2remove = new ArrayList<>();

            for (int[][] board : this.boards) {
                int[] recentlyUpdated = updateBoard(board, number);

                if (has5(board, recentlyUpdated)) { boards2remove.add(board); }
            }

            for (int[][] b : boards2remove) {
                this.boards.remove(b);

                if (this.boards.size() == 0) {
                    dumpSol(b, number);
                    return;
                }
            }
        }
    }

    private int[] updateBoard(int[][] board, int number) {
        int[] coordinates = new int[2];

        for (int i=0; i < 5; ++i) {
            for (int j=0; j < 5; ++j) {
                if (board[i][j] == number) {
                    board[i][j]    = -1;
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }

        return coordinates;
    }

    private boolean has5(int[][] board, int[] recentlyUpdated) {
        int columnCount = 0;
        int rowCount    = 0;

        for (int j=0; j < 5; ++j) {
            if (board[recentlyUpdated[0]][j] == -1) { rowCount++; }
        }

        for (int i=0; i < 5; ++i) {
            if (board[i][recentlyUpdated[1]] == -1) { columnCount++; }
        }

        return (columnCount == 5) || (rowCount == 5);
    }

    private void dumpSol(int[][] board, int number) {
        int sum = 0;

        for (int[] row : board) {
            for (int i : row) {
                if (i != -1) { sum += i; }
            }
        }

        System.out.println("Total score: " + sum * number);
    }
}