package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.PieceFactory;
import chess.pieces.Position;
import chess.pieces.enums.Type;


public class ChessGame {

    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void move(String positionString, Piece piece) {
        Position position = new Position(positionString);

        Rank rank = board.findRank(position);
        rank.setPiece(position, piece);
    }

    public void move(String curr, String after) {
        Position currPosition = new Position(curr);
        Position afterPosition = new Position(after);

        Piece currPiece = board.findRank(currPosition).getPiece(currPosition);

        boolean isMove = currPiece.verifyMovePosition(currPosition, afterPosition);//예외를 던지면 처리하는 로직 필요

        if (isMove) {
            move(after, currPiece);
            move(curr, PieceFactory.getInstance().createBlank());
        }
        else {
            System.out.println("올바르지 않은 위치입니다.");
        }

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
