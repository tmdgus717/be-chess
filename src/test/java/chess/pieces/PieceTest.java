package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("팩토리 메소드로 각 기물들의 색과 표현의 생성이 올바르게 되는지 확인")
    public void create_piece() {
        verifyPiece(Piece.createWhite(Type.PAWN), Color.WHITE, Type.PAWN);
        verifyPiece(Piece.createBlack(Type.PAWN), Color.BLACK, Type.PAWN);
        verifyPiece(Piece.createWhite(Type.KNIGHT), Color.WHITE, Type.KNIGHT);
        verifyPiece(Piece.createBlack(Type.KNIGHT), Color.BLACK, Type.KNIGHT);
        verifyPiece(Piece.createWhite(Type.ROOK), Color.WHITE, Type.ROOK);
        verifyPiece(Piece.createBlack(Type.ROOK), Color.BLACK, Type.ROOK);
        verifyPiece(Piece.createWhite(Type.BISHOP), Color.WHITE, Type.BISHOP);
        verifyPiece(Piece.createBlack(Type.BISHOP), Color.BLACK, Type.BISHOP);
        verifyPiece(Piece.createWhite(Type.QUEEN), Color.WHITE, Type.QUEEN);
        verifyPiece(Piece.createBlack(Type.QUEEN), Color.BLACK, Type.QUEEN);
        verifyPiece(Piece.createWhite(Type.KING), Color.WHITE, Type.KING);
        verifyPiece(Piece.createBlack(Type.KING), Color.BLACK, Type.KING);
    }

    private void verifyPiece(Piece piece, Color color, Type type) {
        if(color == Color.WHITE){
            assertThat(piece.isWhite()).isTrue();
            assertThat(piece.getType()).isEqualTo(type);
        }
        if(color == Color.BLACK){
            assertThat(piece.isBlack()).isTrue();
            assertThat(piece.getType()).isEqualTo(type);
        }
    }

    @Test
    @DisplayName("검정색 Type 기물과 흰색 Type 기물의 식별 문자를 제대로 가져오는지 확인하는 테스트")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}
