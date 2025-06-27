package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;


public class ChessGame {

    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public Double calculatePoint(Color color) {
        double point = 0;
        for (Rank rank : board.getRanks()) {
            point += rank.calculatePointBy(color);
        }

        point = calculatePointDetail(point, color);

        return point;
    }

    private double calculatePointDetail(double point, Color color) {

        for (int i = 0; i < 8; i++) {
            int count = 0;
            for (Rank rank : board.getRanks()) {
                Piece piece = rank.getPieceByIndex(i);
                if (piece.isSame(color, Type.PAWN)) {
                    count++;
                }
            }

            if (count >= 2) {
                double pawnPoint = Type.PAWN.getScore() * count;
                pawnPoint /= 2;
                point -= pawnPoint;
            }
        }

        return point;
    }
}
