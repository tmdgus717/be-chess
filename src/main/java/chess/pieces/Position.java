package chess.pieces;

public class Position {
    private int x;
    private int y;

    public Position(String position) {
        var x = position.charAt(0) - 'a';
        // 8 -> 0
        // 1 -> 7
        var y = '8' - position.charAt(1);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
