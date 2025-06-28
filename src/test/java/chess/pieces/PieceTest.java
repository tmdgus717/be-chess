package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    PieceFactory pieceFactory;

    @Test
    @DisplayName("팩토리 메소드로 각 기물들의 색과 표현의 생성이 올바르게 되는지 확인")
    public void create_piece() {
        verifyPiece(pieceFactory.createWhite(Type.PAWN), Color.WHITE, Type.PAWN);
        verifyPiece(pieceFactory.createBlack(Type.PAWN), Color.BLACK, Type.PAWN);
        verifyPiece(pieceFactory.createWhite(Type.KNIGHT), Color.WHITE, Type.KNIGHT);
        verifyPiece(pieceFactory.createBlack(Type.KNIGHT), Color.BLACK, Type.KNIGHT);
        verifyPiece(pieceFactory.createWhite(Type.ROOK), Color.WHITE, Type.ROOK);
        verifyPiece(pieceFactory.createBlack(Type.ROOK), Color.BLACK, Type.ROOK);
        verifyPiece(pieceFactory.createWhite(Type.BISHOP), Color.WHITE, Type.BISHOP);
        verifyPiece(pieceFactory.createBlack(Type.BISHOP), Color.BLACK, Type.BISHOP);
        verifyPiece(pieceFactory.createWhite(Type.QUEEN), Color.WHITE, Type.QUEEN);
        verifyPiece(pieceFactory.createBlack(Type.QUEEN), Color.BLACK, Type.QUEEN);
        verifyPiece(pieceFactory.createWhite(Type.KING), Color.WHITE, Type.KING);
        verifyPiece(pieceFactory.createBlack(Type.KING), Color.BLACK, Type.KING);
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
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}
