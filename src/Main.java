public class Main {
    public static void main(String[] args) {
       Board board = new Board(Board.createArr());
       board.solve(0,0);
       System.out.println(board.getArray());
    }

}
