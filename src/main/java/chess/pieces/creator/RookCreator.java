package chess.pieces.creator;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Rook;
import chess.pieces.enums.Type;

public class RookCreator implements PieceCreator{

    @Override
    public Type getType() {
        return Type.ROOK;
    }

    @Override
    public Piece create(Color color) {
        return new Rook(color);
    }
}
