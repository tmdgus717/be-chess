package chess.pieces;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1),
        ROOK('r', 5),

        KNIGHT('n', 2.5),
        BISHOP('b', 3),

        QUEEN('q', 9),
        KING('k', 0),
        NO_PIECE('.', 0);

        private char representation;
        private double score;

        Type(char representation, double score) {
            this.representation = representation;
            this.score = score;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public double getScore() {
            return score;
        }
    }

    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    public static Piece createBlack(Type type){
        return new Piece(Color.BLACK, type);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isSame(Color color, Type type) {
        if (this.color == color && this.type == type) {
            return true;
        }
        return false;
    }

    public Double getPoint() {
        return this.type.score;
    }

    @Override
    public boolean equals(Object o) {
        Piece piece = (Piece) o;
        return isSame(piece.color, piece.type);
    }
}
