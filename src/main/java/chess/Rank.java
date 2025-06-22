package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;

public class Rank {

    private static final int COLUMN_SIZE = 8;
    private static final int BLACK_PIECES_INDEX = 0;
    private static final int BLACK_PAWNS_INDEX = 1;
    private static final int WHITE_PAWNS_INDEX = 6;
    private static final int WHITE_PIECES_INDEX = 7;
    private static final List<Type> TYPE_ORDER = List.of(
        Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN, Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK
    );

    List<Piece> pieces = new ArrayList<>(COLUMN_SIZE);

    public Rank(int row) {
         fillRank(row);
    }

    public Piece getPiece(int col) {
        return pieces.get(col);
    }

    public void fillRank(int row) {
        if (row == BLACK_PIECES_INDEX){
            fillPiecesByTypeOrder(Color.BLACK);
            return;
        }
        if (row == BLACK_PAWNS_INDEX){
            fillPieces(Type.PAWN, Color.BLACK);
            return;
        }
        if (row == WHITE_PAWNS_INDEX){
            fillPieces(Type.PAWN, Color.WHITE);
            return;
        }
        if(row == WHITE_PIECES_INDEX){
            fillPiecesByTypeOrder(Color.WHITE);
            return;
        }
        fillPieces(Type.NO_PIECE, Color.NOCOLOR);
    }

    private void fillPiecesByTypeOrder(Color color) {
        for (Type type : TYPE_ORDER) {
            pieces.add(createPiece(type, color));
        }
    }

    private void fillPieces(Type type, Color color) {
        for (int i = 0; i < COLUMN_SIZE; i++) {
            pieces.add(createPiece(type, color));
        }
    }

    private Piece createPiece(Type type, Color color) {
        if (type == Type.NO_PIECE) {
            return Piece.createBlank();
        }
        return color == Color.BLACK ? Piece.createBlack(type) : Piece.createWhite(type);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public int countPieceBy(Color color, Type type) {
        int count = 0;
        for (Piece piece : pieces) {
            if(piece.isSame(color, type)){
                count++;
            }
        }
        return count;
    }

    public int countPieces() {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.getType() != Type.NO_PIECE) {
                count++;
            }
        }
        return count;
    }
}
