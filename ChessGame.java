public class ChessGame {

    private Board board;


    public ChessGame(int length, int width) {
        this.board = new Board(length, width);
    }

    public void placeRook(int rank, int file) {
        int influence = 0;

        board.clearBoard();
        board.getSquare(rank, file).setPiece("r");
        for (int r = 1; r < board.getLength() + 1; r++) {
            for (int f = 1; f < board.getWidth() + 1; f++) {
                if (r == rank || f == file) {
                    board.getSquare(r, f).toggleHighlight();
                }
            }
        }
        /*for (int count = 1; count < board.getLength() + 1; count++) {
            board.getSquare(rank, count).toggleHighlight();
            board.getSquare(count, file).toggleHighlight();
        }*/

        for (int r = 1; r < board.getLength() + 1; r++) {
            for (int f = 1; f < board.getWidth() + 1; f++) {
                if (board.getSquare(r, f).isHighlighted()) {
                    influence++;
                }
            }
        }

        System.out.println();
        System.out.println("influence: " + influence);
    }

    public void placeKnight(int rank, int file) {
        int influence = 0;
        board.clearBoard();
        board.getSquare(rank, file).setPiece("k");

        for (int r = 1; r < board.getLength() + 1; r++) {
            for (int f = 1; f < board.getWidth() + 1; f++) {
                if ( ( board.getSquare(r - 2, f - 1) != null && r - 2 == rank && f - 1 == file ) || 
                ( board.getSquare(r - 1, f - 2) != null && r - 1 == rank && f - 2 == file ) ||
                ( board.getSquare(r + 2, f + 1) != null && r + 2 == rank && f + 1 == file ) ||
                ( board.getSquare(r + 1, f + 2) != null && r + 1 == rank && f + 2 == file ) || 
                ( board.getSquare(r - 2, f + 1) != null && r - 2 == rank && f + 1 == file ) || 
                ( board.getSquare(r - 1, f + 2) != null && r - 1 == rank && f + 2 == file ) ||
                ( board.getSquare(r + 2, f - 1) != null && r + 2 == rank && f - 1 == file ) ||
                ( board.getSquare(r + 1, f - 2) != null && r + 1 == rank && f - 2 == file )
                ) {
                    board.getSquare(r, f).toggleHighlight();
                    influence++;
                }
            }
        }

        System.out.println();
        System.out.println("influence: " + influence);
    }

    public void placeBishop(int rank, int file) {
        int influence = 0;
        board.clearBoard();
        board.getSquare(rank, file).setPiece("b");

        for (int c = 1; c + rank < board.getLength() + 1 && c + file < board.getWidth() + 1; c++) {
            board.getSquare(rank + c, file + c).toggleHighlight();
            influence++;
        }
        for (int c = 1; rank - c > 0 && c + file < board.getWidth() + 1; c++) {
            board.getSquare(rank - c, file + c).toggleHighlight();
            influence++;
        }
        for (int c = 1; c + rank < board.getLength() + 1 && file - c > 0; c++) {
            board.getSquare(rank + c, file - c).toggleHighlight();
            influence++;
        }
        for (int c = 1; rank - c > 0 && file - c > 0; c++) {
            board.getSquare(rank - c, file - c).toggleHighlight();
            influence++;
        }

        System.out.println();
        System.out.println("influence: " + influence);
    }

    public void placeQueen(int rank, int file) {
        int influence = 0;
        board.clearBoard();
        board.getSquare(rank, file).setPiece("q");

        for (int c = 1; c + rank < board.getLength() + 1 && c + file < board.getWidth() + 1; c++) {
            board.getSquare(rank + c, file + c).toggleHighlight();
        }
        for (int c = 1; rank - c > 0 && c + file < board.getWidth() + 1; c++) {
            board.getSquare(rank - c, file + c).toggleHighlight();
        }
        for (int c = 1; c + rank < board.getLength() + 1 && file - c > 0; c++) {
            board.getSquare(rank + c, file - c).toggleHighlight();
        }
        for (int c = 1; rank - c > 0 && file - c > 0; c++) {
            board.getSquare(rank - c, file - c).toggleHighlight();
        }

        for (int r = 1; r < board.getLength() + 1; r++) {
            for (int f = 1; f < board.getWidth() + 1; f++) {
                if (r == rank || f == file) {
                    board.getSquare(r, f).toggleHighlight();
                }
            }
        }

        for (int r = 1; r < board.getLength() + 1; r++) {
            for (int f = 1; f < board.getWidth() + 1; f++) {
                if (board.getSquare(r, f).isHighlighted()) {
                    influence++;
                }
            }
        }

        System.out.println();
        System.out.println("influence: " + influence);
    }

    public int queenInfluence(int rank, int file) {
        int influence = 0;
        board.clearBoard();

        for (int c = 1; c + rank < board.getLength() + 1 && c + file < board.getWidth() + 1; c++) {
            influence++;
        }
        for (int c = 1; rank - c > 0 && c + file < board.getWidth() + 1; c++) {
            influence++;
        }
        for (int c = 1; c + rank < board.getLength() + 1 && file - c > 0; c++) {
            influence++;
        }
        for (int c = 1; rank - c > 0 && file - c > 0; c++) {
            influence++;
        }

        for (int count = 1; count < 9; count++) {
            influence += 2;
        }

        return influence;
    }

    public void maxQueenInfluence() {
        int currentMax = 0;
        for (int r = 0; r < board.getLength() + 1; r++) {
            for (int f = 0; f < board.getWidth() + 1; f++) {
                if (queenInfluence(r, f) >= currentMax) {
                    currentMax = queenInfluence(r, f);
                }
            }
        }

        for (int r = 0; r < board.getLength() + 1; r++) {
            for (int f = 0; f < board.getWidth() + 1; f++) {
                if (queenInfluence(r, f) == currentMax) {
                    System.out.println("rank: " + r + ", file: " + f);
                }
            }
        }
    }

    public void testPrintBoard() {
        board.printBoard();
    }

    public static void main(String[] args) {
        ChessGame game1 = new ChessGame(8, 8);
        game1.placeRook(3, 4);
        game1.testPrintBoard();

        System.out.println();

        ChessGame game2 = new ChessGame(10, 6);
        game2.placeKnight(1, 1);
        game2.testPrintBoard();

        System.out.println();

        ChessGame game3 = new ChessGame(6, 10);
        game3.placeBishop(4, 4);
        game3.testPrintBoard();

        System.out.println();

        ChessGame game4 = new ChessGame(5, 8);
        game4.placeQueen(5, 7);
        game4.testPrintBoard();

        System.out.println();
        System.out.println();

        ChessGame game5 = new ChessGame(9, 13);
        game5.maxQueenInfluence();
    }
}
