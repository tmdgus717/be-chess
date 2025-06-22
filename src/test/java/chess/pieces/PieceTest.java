package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("팩토리 메소드로 각 기물들의 색과 표현의 생성이 올바르게 되는지 확인")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
    @Test
    @DisplayName("검은색 말인지 확인하는 테스트")
    void isBlackTest() {
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    @Test
    @DisplayName("하얀색 말인지 확인하는 테스트")
    void isWhiteTest() {
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
    }
    @Test
    @DisplayName("검정색 Type 기물과 흰색 Type 기물의 식별 문자를 제대로 가져오는지 확인하는 테스트")
    void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}