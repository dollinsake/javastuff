/**
 * Created by Dollins on 3/1/16.
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
public class BattleshipLab { //if turns is less than the number of high score turns is the new high score
    //print out the new high score
    // if turns<highscore
    //high score equals to turns
    private static int highscore=999;


    Scanner input = new Scanner(System.in);


    public static final boolean DEBUG = false;
    private static int tries = 0;
    private static int hits = 0;

    public static void createBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "~";
            }
        }
    }

    public static void showBoard(String[][] board) {

        for (int r = 0; r < board.length; r++) {
            if (DEBUG == true) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(" " + board[r][c]);
                }
                System.out.println("");
            } else {
                for (int c = 0; c < board[0].length; c++) {
                    if ((board[r][c].equals("S")) || (board[r][c].equals("X"))) {
                        System.out.print(" " + "~");
                    } else {
                        System.out.print(" " + board[r][c]);
                    }
                }
                System.out.println("");
            }
        }

    }

    public static void createShip(String[][] board) {
        int height = board.length;
        int width = board[0].length;
        int size = height * width;
        height -= 1;
        width -= 1;
        int shipheight = height - 3;
        int shipwidth = width - 3;
        if (size >= 9 && size <= 16) {
            int ship = 0;
            while (ship < 3) {
                if (Math.random() < 0.5) {
                    int col = (int) (Math.random() * shipwidth);
                    int row = (int) (Math.random() * height);
                    for (int i = 0; i < 3; i++) {
                        board[col+i][row] = "S";
                        ship += 1;
                    }
                } else if (Math.random() > 0.5) {
                    int col = (int) (Math.random() * width);
                    int row = (int) (Math.random() * shipheight);
                    for (int i = 0; i < 3; i++) {
                        board[col][row+i] = "S";
                        ship += 1;
                    }
                }
            }
            int check = 0;
            while (check < 1) {
                int col = (int) (Math.random() * width);
                int row = (int) (Math.random() * height);
                if (board[col][row].equals("~")){
                    board[col][row] = "X";
                    check += 1;
                }
            }
        }
        else if (size >= 17 && size <= 36) {
            int ship = 0;
            while (ship < 6) {
                if (Math.random() < 0.5) {
                    int col = (int) (Math.random() * shipwidth);
                    int row = (int) (Math.random() * height);
                    if ((board[col+0][row].equals("~")) || (board[col+1][row].equals("~")) || (board[col+2][row].equals("~"))) {
                        for (int i = 0; i < 3; i++) {
                            board[col+i][row] = "S";
                            ship += 1;
                        }
                    }
                } else if (Math.random() > 0.5) {
                    int col = (int) (Math.random() * width);
                    int row = (int) (Math.random() * shipheight);
                    if ((board[col][row+0].equals("~")) || (board[col][row+1].equals("~")) || (board[col][row+2].equals("~"))) {
                        for (int i = 0; i < 3; i++) {
                            board[col][row+i] = "S";
                            ship += 1;
                        }
                    }
                }
            }


            int check = 0;
            while (check < 2) {
                int col = (int) (Math.random() * width);
                int row = (int) (Math.random() * height);
                if (board[col][row].equals("~")) {
                    board[col][row] = "X";
                    check += 1;
                }
            }
        }

        else if (size > 36) {
            int ship = 0;
            while (ship < 9) {
                if (Math.random() < 0.5) {
                    int col = (int) (Math.random() * shipwidth);
                    int row = (int) (Math.random() * height);
                    if ((board[col][row].equals("~")) || (board[col][row + 1].equals("~")) || (board[col][row + 2].equals("~"))) {
                        for (int i = 0; i < 3; i++) {
                            board[col+i][row] = "S";
                            ship += 1;
                        }
                    }
                } else if (Math.random() > 0.5) {
                    int col = (int) (Math.random() * width);
                    int row = (int) (Math.random() * shipheight);
                    if ((board[col][row].equals("~")) || (board[col + 1][row].equals("~")) || (board[col + 2][row].equals("~"))) {
                        for (int i = 0; i < 3; i++) {
                            board[col][row+i] = "S";
                            ship += 1;
                        }
                    }
                }
            }


            int check = 0;
            while (check < 3) {
                int col = (int) (Math.random() * width);
                int row = (int) (Math.random() * height);
                if (board[col][row].equals("~")){
                    board[col][row] = "X";
                    check += 1;
                }
            }
        }
    }


    public static int userFire(String[][] board, int hits, int tries) {
        Scanner input = new Scanner(System.in);
        int row, col;
        System.out.println("Tries: " + tries );
        System.out.println("Select a row and a col to fire in, respectively: ");
        row = input.nextInt();
        col = input.nextInt();
        while (row > board.length || row < 1 || col > board[0].length || col < 1)
        {
            System.out.println("Enter a valid row and col!");
            row = input.nextInt();
            col = input.nextInt();
        }
        if (board[row - 1][col - 1].equals("S")) {
            System.out.println("Oh NOOOOOO, Its a Hit");
            board[row - 1][col - 1] = "!";
        }
        else if (board[row-1][col-1].equals("X")){
            System.out.println("You blew up a mine.");
            board[row - 1][col - 1] = "O";
            /*implement to check whether you are near ship here*/
            /*add two tries here*/
        }



        else {
           System.out.println("Ha Ha You Missed");
            board[row - 1][col - 1] = "M";
            /*implement to check whether you are near ship here*/
            if(col-1>0 && board[row-1][col-2].equals("S") ){ //check if its a ship for the rest of the iff statements
                System.out.println(" Very Close");
                board[row-1][col-1]="A";

            }
            else if(col-2>0 && board[row-1][col-3].equals("S") ){
                System.out.println("Close");
                board[row-1][col-1]="C";

            }
            else if(row-1>0&& board[row-2][col-1].equals("S") ){
                System.out.println("Very close");
                board[row-1][col-1]="A";

            }
            else if(row-2>0&& board[row-3][col-1].equals("S") ){
                System.out.println("Close");
                board[row-1][col-1]="C";

            }
            else if(col+1<board[0].length&& board[row-1][col].equals("S") ){
                System.out.println("Very close");
                board[row-1][col-1]="A";

            }
            else if(col+2<board[0].length&& board[row-1][col+1].equals("S") ){
                System.out.println("Close");
                board[row-1][col-1]="C";
            }
            else if(row+1<board[0].length&& board[row][col-1].equals("S") ){
                System.out.println("Very close");
                board[row-1][col-1]="A";
            }
            else if(row+2<board.length&& board[row+1][col-1].equals("S") ){
                System.out.println("Close");
                board[row-1][col-1]="C";

            }
        }


        return hits;
    }
    public static void main(String[] arg) {
        Scanner z = new Scanner(System.in);
        System.out.println("Enter number of rows and cols, respectively: ");
        int x = z.nextInt();
        int y = z.nextInt();
        while(x<3 || y<3 || x>10 || y>10){
            System.out.println("Invalid entry! Min of 3 X 3 and Max of 10 X 10");
            System.out.println("Enter number of rows and cols, respectively: ");
            x = z.nextInt();
            y = z.nextInt();
        }
        String[][] board = new String[x][y];
        createBoard(board);
        createShip(board);

        int size = x * y;
        if (size >= 9 && size <= 16){
            System.out.println("There is 1 ship and 1 mine.");
        }
        else if (size >= 17 && size <= 36){
            System.out.println("There are 2 ships and 2 mines.");
        }
        else{
            System.out.println("There are 3 ships and 3 mines.");
        }


        size = x * y;
        int cond;
        if (size >= 9 && size <= 16) {
            System.out.println("There is 1 ship and 1 mine.");
            cond = 3;
        } else if (size >= 17 && size <= 36) {
            System.out.println("There are 2 ships and 2 mines.");
            cond = 6;
        } else {
            System.out.println("There are 3 ships and 3 mines.");
            cond = 9;
        }


        while (hits != cond) {
            showBoard(board);
            userFire(board,x,y);
        }
        System.out.println("You win! You finished in " + tries + " tries!");

    }

// Now use p the same as we print with System.out
// for example,

}


