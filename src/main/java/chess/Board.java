package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int RANK_SIZE = 8;

    private final List<Rank> ranks = new ArrayList<>(RANK_SIZE);

    public void initialize() { // 중복 삭제
        for (int row = 0; row < RANK_SIZE; row++) {
            ranks.add(new Rank(row));
        }
    }

    private String makeRepresentations(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            if (piece.isBlack()){
                stringBuilder.append(piece.getType().getBlackRepresentation());
            }else {
                stringBuilder.append(piece.getType().getWhiteRepresentation());
            }
        }
        return String.valueOf(stringBuilder);
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank : ranks) {
            stringBuilder.append(appendNewLine(makeRepresentations(rank)));
        }
        return String.valueOf(stringBuilder);
    }

    public int countPieceBy(Color color, Type type) {
        int count = 0;

        for (Rank rank : ranks) {
            count += rank.countPieceBy(color, type);
        }

        return count;
    }

    public int countAllPieces() {
        int count = 0;

        for (Rank rank : ranks) {
            count += rank.countPieces();
        }

        return count;
    }


//    private int getCount(int count, int column) {
//        if (isPieces(column)) {
//            count += size(board.get(column));
//        }
//        return count;
//    }
//
//    private boolean isPieces(int column) {
//        return column == BLACK_PIECES_INDEX || column == BLACK_PAWNS_INDEX
//            || column == WHITE_PAWNS_INDEX || column == WHITE_PIECES_INDEX;
//    }

}
