public class Main {

    public static final int size = 3;
    public static final char playerX = 'X';
    public static final char playerO = 'O';
    private char board[][];

    private char currPlayer;
    Scanner sc = new Scanner(System.in);

    public Main() {
        board = new char[size][size];
        currPlayer = 'X';

        // We initiaize a board from digit 0-8

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (char) ('0');
            }

        }
    }

    // Print a board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf(" %s ", "" + board[i][j]);
                if (j + 1 < size) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i + 1 < size) {
                System.out.println("-----------");
            }
        }
    }


    // Method to  check the winner
    public boolean checkWinner(char player) {
        // check horizontal
        for (int i = 0; i < board.length; i++) {
            if (
                    board[i][0] == player &&
                            board[i][1] == player &&
                            board[i][2] == player) {
                return true;
            }

        }

        //check vertical
        for (int j = 0; j < board.length; j++) {
            if (
                    board[0][j] == player &&
                            board[1][j] == player &&
                            board[2][j] == player) {
                return true;
            }

        }

        // diagonal
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        // anti diagonal
        if (board[2][0] == player &&
                board[1][1] == player &&
                board[0][2] == player) {
            return true;
        }
        return false;
    }

    // Method to check board is full
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Character.isDigit(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // If game is over
    public boolean gameOver() {
        return checkWinner(playerX) || checkWinner(playerO) ||
                isBoardFull();
    }

    // Make move
    public int makeMove() {
        System.out.println("Player " + currPlayer + " turn Chose a boxNumber: ");
        int boxNumber;
        boxNumber = sc.nextInt();

        if (boxNumber < 0 || boxNumber > 8) {
            System.out.println("Input box number is invalid! plese chose a valid box number");
            return makeMove();
        }
        int i = boxNumber / size;
        int j = boxNumber % size;
        if (board[i][j] == playerO || board[i][j] == playerX) {
            System.out.println(" This box is already occupied! Try again");
            return makeMove();
        }
        return boxNumber;
    }

    // Logic to play the game
    public void play() {
        while (!gameOver()) {
            printBoard();

            // change line
            System.out.println();

            int boxNumber = makeMove();

            int i = boxNumber / size;
            int j = boxNumber % size;
            board[i][j] = currPlayer;

            // switch player
            currPlayer = currPlayer == playerX ? playerO : playerX;
        }

        // Winner condition
        if (checkWinner(playerX)) {
            System.out.println("player X win :)");
        } else if (checkWinner(playerO)) {
            System.out.println("player O win :)");
        } else {
            System.out.println("Match draw :(");
        }
    }

    public static void main(String[] args) throws Exception {
        Main ttt = new Main();
        ttt.play();
    }
}
