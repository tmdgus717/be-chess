package chess.pieces.creator;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;

public interface PieceCreator {
    Type getType();
    Piece create(Color color);
}
