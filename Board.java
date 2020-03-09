import java.awt.Color;

public class Board {

    private Square[][] squares;

    public Board(int length, int width) {
        squares = new Square[length][width];

        for (int row = 0; row < squares.length; row++) {

            for (int col = 0; col < squares[0].length; col++) {
                boolean isBlack = false;
                if (row % 2 == col % 2) {
                    isBlack = true;
                }

                int rank = squares.length - row;
                int file = col + 1;
                Color color = Color.WHITE;
                if (isBlack) {
                    color = Color.BLACK;
                }

                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public Square getSquare(int rank, int file) {
        if (rank > 0 && file > 0 && rank <= getLength() && file <= getWidth()) {
            return squares[getLength() - rank][file - 1];
        }
        return null;
    }

    public int getLength() {
        return squares.length;
    }

    public int getWidth() {
        return squares[0].length;
    }

    public void clearBoard() {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[0].length; col++) {
                if (squares[row][col].isHighlighted()) {
                    squares[row][col].toggleHighlight();
                }
            }
        }
    }

    public void printBoard() {
        String black = "*";
        String white = "_";
        String rook = "r";
        String knight = "k";
        String highlighted = "h";
        Square currentSquare = null;

        for (int rank = 0; rank < squares.length; rank++) {
            System.out.println();
            for (int file = 0; file < squares[0].length; file++) {
                currentSquare = squares[rank][file];
                if (currentSquare.getPiece() != null ) {
                    System.out.print(currentSquare.getPiece() + " ");
                }
                else if (currentSquare.isHighlighted()) {
                    System.out.print("+ ");
                }
                else if (currentSquare.getColor().equals(Color.BLACK)) {
                    System.out.print("* ");
                }
                else if (currentSquare.getColor().equals(Color.WHITE)) {
                    System.out.print("^ ");
                }
                
            }
        }

    }
}