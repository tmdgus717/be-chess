import chess.Board;

import java.util.Scanner;

public class Main {

    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals(START)) {
                board.initialize();
                System.out.println(board.showBoard());
            }

            if (command.startsWith(MOVE)) {
                String[] s = command.split(" ");
                String before = s[1];
                String after = s[2];
                board.move(before, after);
                System.out.println(board.showBoard());
            }

            if (command.equals(END)) {
                break;
            }
        }
    }
}
