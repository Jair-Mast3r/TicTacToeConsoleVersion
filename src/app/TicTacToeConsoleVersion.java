package app;
import java.util.Scanner;

public class TicTacToeConsoleVersion {
    private static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int move;
        boolean gameWon = false;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            if (scanner.hasNextInt()) {
                move = scanner.nextInt() - 1;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            if (move < 0 || move > 8 || board[move] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[move] = currentPlayer;
            gameWon = checkWin();

            if (gameWon || isBoardFull()) {
                printBoard();
                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("The game is a draw!");
                }
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == currentPlayer && board[i * 3 + 1] == currentPlayer && board[i * 3 + 2] == currentPlayer) {
                return true;
            }
            if (board[i] == currentPlayer && board[i + 3] == currentPlayer && board[i + 6] == currentPlayer) {
                return true;
            }
        }
        return (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) ||
               (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }
}
