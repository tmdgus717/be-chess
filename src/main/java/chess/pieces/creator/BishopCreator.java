package chess.pieces.creator;

import chess.pieces.Bishop;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;

public class BishopCreator implements PieceCreator{

    @Override
    public Type getType() {
        return Type.BISHOP;
    }

    @Override
    public Piece create(Color color) {
        return new Bishop(color);
    }
}
