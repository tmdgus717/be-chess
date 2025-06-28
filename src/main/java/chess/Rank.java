package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.PieceFactory;
import chess.pieces.Position;
import chess.pieces.enums.Type;
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


    PieceFactory pieceFactory = PieceFactory.getInstance();
    List<Piece> pieces = new ArrayList<>(COLUMN_SIZE);

    public Rank() {
        fillPieces(Type.NO_PIECE, Color.NOCOLOR);
    }

    public Rank(int row) {
         fillRank(row);
    }

    public Piece getPiece(Position position) {
        return pieces.get(position.getX());
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
            return pieceFactory.createBlank();
        }
        return color == Color.BLACK ? pieceFactory.createBlack(type) : pieceFactory.createWhite(type);
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

    public void setPiece(Position position, Piece piece) {
        pieces.set(position.getX(), piece);
    }

    public Double calculatePointBy(Color color) {
        return pieces.stream()
            .filter(piece -> piece.getColor() == color)
            .mapToDouble(Piece::getPoint).sum();
    }

    public Piece getPieceByIndex(int index) {
        return pieces.get(index);
    }
}
