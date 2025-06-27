package chess.pieces.creator;

import chess.pieces.Knight;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;

public class KnightCreator implements PieceCreator {

    @Override
    public Type getType() {
        return Type.KNIGHT;
    }

    @Override
    public Piece create(Color color) {
        return new Knight(color);
    }
}
