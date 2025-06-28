import chess.Board;

import chess.ChessGame;
import chess.ChessView;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.PieceFactory;
import chess.pieces.creator.BishopCreator;
import chess.pieces.creator.KingCreator;
import chess.pieces.creator.PawnCreator;
import chess.pieces.creator.PieceCreator;
import chess.pieces.creator.QueenCreator;
import chess.pieces.creator.RookCreator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        ChessView chessView = new ChessView(board);
        ChessGame chessGame = new ChessGame(board);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals(START)) {
                board.initialize();
                System.out.println(chessView.showBoard());
            }

            if (command.startsWith(MOVE)) {
                String[] position = extractPosition(command);

                chessGame.move(position[0], position[1]);
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
