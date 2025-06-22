package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int RANK_SIZE = 8;

    private final List<Rank> ranks = new ArrayList<>(RANK_SIZE);

    public void initialize() { // 중복 삭제
        int row = 0;
        for (Rank rank : ranks) {
            rank.fillRank(row);
            row++;
        }
    }

    public void add(final Piece piece) {
        this.pieces.add(piece);
    }

    public int size(List<Piece> pieces) {
        return pieces.size();
    }

    public Piece findPawn(final int index) {
        return this.pieces.get(index);
    }



    private void addBoard() {
        //pawns리스트를 copiedPawns에 복사한다 :: clear하면 리스트 내의 모든 값이 사라지므로 복사하여 저장
        List<Piece> copiedPieces = new ArrayList<>();
        copiedPieces.addAll(pieces);
        board.add(copiedPieces);
        pieces.clear();
    }

    public String getWhitePawnsResult() {
        return makeRepresentations(board.get(WHITE_PAWNS_INDEX));
    }

    public String getBlackPawnsResult() {
        return makeRepresentations(board.get(BLACK_PAWNS_INDEX));
    }

    private String makeRepresentations(List<Piece> pieces) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : pieces) {
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
        for (int column = 0; column < BOARD_SIZE; column++) {
            stringBuilder.append(appendNewLine(makeRepresentations(board.get(column))));
        }
        return String.valueOf(stringBuilder);
    }

    public int pieceCount() {
        int count = 0;
        for (int column = 0; column < RANK_SIZE; column++) {
            count = getCount(count, column);
        }
        return count;
    }

    private int getCount(int count, int column) {
        if (isPieces(column)) {
            count += size(board.get(column));
        }
        return count;
    }

    private boolean isPieces(int column) {
        return column == BLACK_PIECES_INDEX || column == BLACK_PAWNS_INDEX
            || column == WHITE_PAWNS_INDEX || column == WHITE_PIECES_INDEX;
    }

}
