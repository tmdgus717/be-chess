package chess.pieces;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('k'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');
        private char representation;
        Type(char representation){
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return  Character.toUpperCase(this.representation);
        }
    }

    private final Color color;
    private final Type name;

    private Piece(Color color, Type name) {
        this.color = color;
        this.name = name;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);

    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
    }

    public static Piece createEmpty() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return name;
    }
    public boolean isBlack() {
        return color.equals("black");
    }

    public boolean isWhite() {
        return color.equals("white");
    }
}