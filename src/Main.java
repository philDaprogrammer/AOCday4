public class Main {
    public static void main(String[] args) {
        Parser parser     = new Parser();
        Solution solution = parser.parse("input.txt");
        solution.solveP1();
        solution.solveP2();
    }
}