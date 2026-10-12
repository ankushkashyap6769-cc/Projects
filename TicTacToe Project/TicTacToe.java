package Game;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class TicTacToe {
    public static void printBoard(char[][] board) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(board[i][j] + " | ");

            }

            System.out.println();
        }
    }
    public static boolean gameDraw(char[][] board){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkCondition(char[][] board){
        //Condition 1 board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X' || board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O'
        if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X' || board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O'){
                return true;
        } else if (board[0][0]=='X' && board[1][0]=='X' && board[2][0]=='X' || (board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O')){
            return true;
        } else if (board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X' || (board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O'))
        {
            return true;
        } else if (board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X' || (board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O')){
            return true;
        } else if (board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X' || (board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O')) {
            return true;
        } else if (board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X' || (board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O')) {
            return true;
        } else if (board[2][0]=='X' && board[2][1]=='X' && board[2][2]=='X' || (board[2][0]=='O' && board[2][1]=='O' && board[2][2]=='O')) {
            return true;
        } else if (board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X' || (board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O')) {
            return true;
        }
        return false;
    }
    static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int moveOne = 0;
        int moveTwo = 0;
        boolean gameOver=false;
        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}

        };
        printBoard(board);
        while(true) {
            System.out.println("Player X move -->");
            while (true) {
                try {
                    moveOne = in.nextInt();
                    moveTwo = in.nextInt();
                } catch (Exception e) {
                    System.out.println("Enter Numbers Only ;( ");
                    in.nextLine();

                }
                if (moveOne >= 0 && moveTwo <= 2 && moveTwo >= 0 && moveTwo <= 2) {
                    if (board[moveOne][moveTwo] == ' ') {
                        board[moveOne][moveTwo] = 'X';
                        break;
                    }
                }
                System.out.println("Invalid Move, Try Again!");
            }
            printBoard(board);
            gameOver=checkCondition(board);
            if(gameOver){
                System.out.println("Player X Wins");
                break;
            }
            if (gameDraw(board)){
                System.out.println("Game is Draw");
                break;
            }

            System.out.println("Player O move -->");
            while (true) {
                try {
//                    moveOne = in.nextInt();
//                    moveTwo = in.nextInt();
                    moveOne = ThreadLocalRandom.current().nextInt(0,3);
                    moveTwo= ThreadLocalRandom.current().nextInt(0,3);
                } catch (Exception e) {
                    //System.out.println("Enter Numbers Only ;( ");
                    //in.nextLine();
                }
                if (moveOne >= 0 && moveOne <= 2 && moveTwo >= 0 && moveTwo <= 2) {
                    if (board[moveOne][moveTwo] == ' ') {
                        board[moveOne][moveTwo] = 'O';
                        break;
                    }
                }
                //System.out.println("Invalid Move, Try Again!");
            }
            gameOver = checkCondition(board);
            printBoard(board);
            if(gameOver){
                System.out.println("Player O Wins!!!");
                break;
            }
            if (gameDraw(board)){
                System.out.println("Game is Draw");
                break;
            }
        }
    }

}
