package lunchgame;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer;
    private static boolean isGameOver;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeGame();
        printBoard();

        while (!isGameOver) {
            makeMove();
            printBoard();
            checkGameStatus();
            switchPlayer();
        }

        displayResult();
        scanner.close();
    }

    private static void initializeGame() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        currentPlayer = 'X';
        isGameOver = false;
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void makeMove() {
        int row, col;

        System.out.println("Player '" + currentPlayer + "', enter your move (row and column): ");
        row = getInput("Enter row: ");
        col = getInput("Enter column: ");

        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
        } else {
            System.out.println("Invalid move. Try again.");
            makeMove();
        }
    }

    private static int getInput(String message) {
        int input = -1;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                if (input >= 1 && input <= 3) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        return input - 1; // Adjust for 0-based array indices
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static void checkGameStatus() {
        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
            isGameOver = true;
        } else if (checkDraw()) {
            System.out.println("It's a draw!");
            isGameOver = true;
        }
    }

    private static boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean checkDraw() {
        // Check if the board is full
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayResult() {
        System.out.println("Game Over!");
        printBoard();
    }
}







	
		

	
