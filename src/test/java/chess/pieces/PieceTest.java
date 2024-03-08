package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

//    @Test
//    @DisplayName("팩토리 메소드로 각 기물들의 색과 표현의 생성이 올바르게 되는지 확인")
//    public void create_piece() {
//        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
//        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
//        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
//        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
//        verifyPiece(Piece.createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
//        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
//        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
//        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
//        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
//        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
//        verifyPiece(Piece.createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENTATION);
//    }

//    private void verifyPiece(final Piece piece, final Color color, final char representation) {
//        assertThat(piece.getColor()).isEqualTo(color);
//        assertThat(piece.getRepresentation()).isEqualTo(representation);
//    }

    @Test
    @DisplayName("검은색 말인지 확인하는 테스트")
    public void isBlackTest() {
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    @Test
    @DisplayName("하얀색 말인지 확인하는 테스트")
    public void isWhiteTest() {
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
    }
    @Test
    @DisplayName("검정색 Type 기물과 흰색 Type 기물의 식별 문자를 제대로 가져오는지 확인하는 테스트")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}