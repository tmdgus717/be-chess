package chess.pieces.creator;

import chess.pieces.King;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;

public class KingCreator implements PieceCreator{

    @Override
    public Type getType() {
        return Type.KING;
    }

    @Override
    public Piece create(Color color) {
        return new King(color);
    }
}
