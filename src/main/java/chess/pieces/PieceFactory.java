package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.creator.BishopCreator;
import chess.pieces.creator.KingCreator;
import chess.pieces.creator.KnightCreator;
import chess.pieces.creator.PawnCreator;
import chess.pieces.creator.PieceCreator;
import chess.pieces.creator.QueenCreator;
import chess.pieces.creator.RookCreator;
import chess.pieces.enums.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieceFactory {

    private static final PieceFactory instance = new PieceFactory();

    private final Map<Type, PieceCreator> pieceCreatorMap = new HashMap<>();

    public PieceFactory() {
        List<PieceCreator> creators = List.of(
            new KingCreator(),
            new QueenCreator(),
            new BishopCreator(),
            new RookCreator(),
            new KnightCreator(),
            new PawnCreator());

        for (PieceCreator creator : creators) {
            pieceCreatorMap.put(creator.getType(), creator);
        }
    }

    public static PieceFactory getInstance() {
        return instance;
    }

    public Piece createBlack(Type type) {
        return createPieceBy(Color.BLACK, type);
    }

    public Piece createWhite(Type type) {
        return createPieceBy(Color.WHITE, type);
    }

    private Piece createPieceBy(Color color, Type type) {
        return pieceCreatorMap.get(type).create(color);
    }

    public Piece createBlank() {
        return new Blank(Color.NOCOLOR);
    }
}
