public class Main {
    public static void main(String[] args) {
        Board board = new Board(Board.createArr());
        boolean solved = board.solve(0, 0);
        Integer[] array = board.getArray();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i * 9 + j]);
            }
            System.out.println("\n");
        }
        if (solved) System.out.println("Sudokun löst! BRA JOBBAT");
        else System.out.println("Sudokun kunde inte lösas");
        System.out.println("Checkrow " + board.checkRow(0, 1));
        System.out.println("Checkcol " + board.checkCol(0, 1));
        System.out.println("CheckSquare " + board.checkSquare(0, 1));
    }

}
