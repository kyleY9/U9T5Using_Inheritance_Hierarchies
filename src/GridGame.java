import java.util.Scanner;

public class GridGame {
    private Space[][] board;
    private Player player;
    private Scanner scanner;

    public GridGame() {
        scanner = new Scanner(System.in);
        createPlayer();
        setupBoard();
        play();
    }

    private void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);
    }

    // initialize the board instance variable to be a 8x8 board;
    // place new Space object with "_" as the symbol into each board position;
    // place the Player object at lower left corner;
    // initialize and place a Goal object with the symbol "X" in the upper right corner;
    // create several Treasure objects (up to you how many), with symbol of your choice,
    // each with a point value that you decide, and place them throughout the board
    private void setupBoard() {
        board = new Space[8][8];
        board[0][7] = new Goal("X");
        board[7][0] = player;

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == null) {
                    if (randTreasureLocation()) {
                        board[i][k] = new Treasure("$", 10);
                    } else {
                        board[i][k] = new Space("_");
                    }
                }
            }
        }
    }

    // helper method: there's a 20% chance for treasure to spawn at a space
    public boolean randTreasureLocation() {
        int num = (int) (Math.random() * 5) + 1;
        return num == 3;
    }

    /* prints the 2D array board, showing the symbol for each Space, e.g.
       _______X
       __#_____
       _____#__
       _#______
       ________
       ______#_
       ________
       M___#___
     */
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                System.out.print(board[i][k].getSymbol());
            }
            System.out.println();
        }
    }

    // plays the game;
    private void play() {

        // WRITE THIS METHOD
        // main game loop:
        // while the player has not yet reached the goal, print the board (complete can call helper method above)
        // then asks user to enter a direction: W, A, S, D (up, left, down, right).
        // if the intended direction is in bounds, move the Player to the new location and fill previous position
        // with a Space object (with "_" symbol).
        // if player moves to a position occupied by a Treasure, add its point value to the players score,
        // and replace that element with a Space object (with "_" symbol).
        // if the player reaches the goal, end the game and print their final score and the number of moves it took
        System.out.println("Collect all treasures to win!");
        while (!(board[0][7] instanceof Player)) {
            printBoard();
            System.out.print("Enter either W, A, S, or D");
            String response = scanner.nextLine();

            if ((!response.equals("W")) && (!response.equals("A")) & (!response.equals("S")) && (!response.equals("D"))) {
                System.out.println("Invalid Response! W, A, S, or D!");
            } else {
                moveASpace(response);
            }
        }
        if (treasuresPresent()) {
            System.out.println("Defeat! You did not collect all the treasures!\nTotal Points: " + player.getScore());
        } else {
            System.out.println("Victory! All treasures collected!\nTotal Points: " + player.getScore());
        }
        System.out.println("Total Moves Taken: " + player.getMoves());
    }

    // more helper methods
    public boolean treasuresPresent() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] instanceof Treasure) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveASpace(String response) {
        if (response.equals("W")) {
            moveUp();
        } else if (response.equals("A")) {
            moveLeft();
        } else if (response.equals("S")) {
            moveDown();
        } else {
            moveRight();
        }
    }

    public int findPlayerRow() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] instanceof Player) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findPlayerColumn() {
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] instanceof Player) {
                    return k;
                }
            }
        }
        return -1;
    }

    public void moveLeft() {
        int row = findPlayerRow();
        int col = findPlayerColumn();
        if (col != 0) {
            if (board[row][col - 1] instanceof Treasure) {
                player.addPoints(((Treasure) board[row][col - 1]).getPointValue());
            }
            board[row][col - 1] = player;
            board[row][col] = new Space("_");
            player.move();
        } else {
            System.out.println("You can't do that!");
        }
    }

    public void moveUp() {
        int row = findPlayerRow();
        int col = findPlayerColumn();
        if (row != 0) {
            if (board[row - 1][col] instanceof Treasure) {
                player.addPoints(((Treasure) board[row - 1][col]).getPointValue());
            }
            board[row - 1][col] = player;
            board[row][col] = new Space("_");
            player.move();
        } else {
            System.out.println("You can't do that!");
        }
    }

    public void moveDown() {
        int row = findPlayerRow();
        int col = findPlayerColumn();
        if (col != 7) {
            if (board[row + 1][col] instanceof Treasure) {
                player.addPoints(((Treasure) board[row + 1][col]).getPointValue());
            }
            board[row + 1][col] = player;
            board[row][col] = new Space("_");
            player.move();
        } else {
            System.out.println("You can't do that!");
        }
    }

    public void moveRight() {
        int row = findPlayerRow();
        int col = findPlayerColumn();
        if (col != 7) {
            if (board[row][col + 1] instanceof Treasure) {
                player.addPoints(((Treasure) board[row][col + 1]).getPointValue());
            }
            board[row][col + 1] = player;
            board[row][col] = new Space("_");
            player.move();
        } else {
            System.out.println("You can't do that!");
        }
    }
}