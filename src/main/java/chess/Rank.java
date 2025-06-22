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

    List<Piece> columns = new ArrayList<>(COLUMN_SIZE);

    public void fillRank(int row) {
        if (row == BLACK_PIECES_INDEX){
            fillByTypeOrder(Color.BLACK);
            return;
        }
        if (row == BLACK_PAWNS_INDEX){
            fillColumns(Type.PAWN, Color.BLACK);
            return;
        }
        if (row == WHITE_PAWNS_INDEX){
            fillColumns(Type.PAWN, Color.WHITE);
            return;
        }
        if(row == WHITE_PIECES_INDEX){
            fillByTypeOrder(Color.WHITE);
            return;
        }
        fillColumns(Type.NO_PIECE, Color.NOCOLOR);
    }

    private void fillByTypeOrder(Color color) {
        for (Type type : TYPE_ORDER) {
            columns.add(createPiece(type, color));
        }
    }

    private void fillColumns(Type type, Color color) {
        for (int i = 0; i < COLUMN_SIZE; i++) {
            columns.add(createPiece(type, color));
        }
    }

    private Piece createPiece(Type type, Color color) {
        if (type == Type.NO_PIECE) {
            return Piece.createBlank();
        }
        return color == Color.BLACK ? Piece.createBlack(type) : Piece.createWhite(type);
    }
}
