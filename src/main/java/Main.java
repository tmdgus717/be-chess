import chess.Board;

import chess.ChessView;
import java.util.Scanner;

public class Main {

    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        ChessView chessView = new ChessView(board);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals(START)) {
                board.initialize();
                System.out.println(chessView.showBoard());
            }

            if (command.startsWith(MOVE)) {
                String[] position = extractPosition(command);

                board.move(position[0], position[1]);
                System.out.println(chessView.showBoard());
            }

            if (command.equals(END)) {
                break;
            }
        }
    }

    private static String[] extractPosition(String command) {
        String[] parts = command.split(" ");
        return new String[] { parts[1], parts[2] };
    }
}
