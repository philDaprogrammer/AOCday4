import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {
    public Solution parse(String filename) {
        ArrayList<Integer> numbers  = new ArrayList<>();
        ArrayList<int[][]>  boards  = new ArrayList<>();

        try {
            FileInputStream stream = new FileInputStream(filename);
            Scanner         sc     = new Scanner(stream);

            while (sc.hasNext()) {
                if (numbers.isEmpty()) {
                    String[] nums = sc.next().split(",");
                    for (String num : nums) { numbers.add(Integer.parseInt(num)); }
                }

                int[][] newBoard = new int[5][5];
                for (int i=0; i < 5; ++i) {
                    for (int j=0; j < 5; ++j) {
                        if (sc.hasNext()) { newBoard[i][j] = Integer.parseInt(sc.next()); }
                    }
                }

                boards.add(newBoard);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Solution(numbers, boards);
    }
}