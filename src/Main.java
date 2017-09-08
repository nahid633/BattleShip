import java.util.*;

/**
 * Created by Nahid on 9/6/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("****Welcome to Battle Ships game ****");
        System.out.println("Right now, sea is empty");
        String[][] gameBoard = new String[10][10];
        String[][] userBoard = new String[10][10];
        String[][] compBoard = new String[10][10];
        int countUShip = 5;
        int countCShip = 5;
        boolean userTurn = true;
        boolean compTurn = false;
        printOut(gameBoard,userBoard,compBoard);
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Y coordinate for your ship " + (i + 1) + ": ");
            int x = input.nextInt();
            System.out.print("Enter X coordinate for your ship" + (i + 1) + ": ");
            int y = input.nextInt();
            if (x >= 10 || y >= 10 || x < 0 || y < 0) {
                System.out.println("Please Enter correct Coordinate");
                i--;
            } else {
                userBoard[x][y] = "@";

            }
        }
        System.out.println("Computer's Turn");
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int x = rand.nextInt(((10 - 1) + 1) + 1);
            int y = rand.nextInt(((10 - 1) + 1) + 1);
            if (x >= 10 || y >= 10 || x < 0 || y < 0) {
                i--;
            } else {
                System.out.println(i + 1 + "ship DEPLOYED");
//                System.out.println("Enter X coordinate for your ship: " + x);
//                System.out.println("Enter Y coordinate for your ship: " + y);
                compBoard[x][y] = "@";
            }
        }
        printOut(gameBoard, userBoard, compBoard);
        System.out.println("|User's ships:" + countUShip + " | Computer's ships :" + countCShip);

        while (true) {
            if (countUShip ==0) {
                System.out.println("Winner is Computer BOmbombom!!!");
                break;
            } else if (countCShip == 0) {
                System.out.println("Winner is User BOmbombom!!!!");
                break;
            }
            if (userTurn) {
                System.out.println("Your Turn :");
                System.out.print("Enter Y coordinate ");
                int x = input.nextInt();
                System.out.print("Enter X coordinate ");
                int y = input.nextInt();
                if (x >= 10 || y >= 10 || x < 0 || y < 0) {
                    System.out.println("Enter valid Coordinate");
                } else {
                    userTurn = false;
                    compTurn = true;
                    if ("@".equals(compBoard[x][y])) {
                        compBoard[x][y] = "x";
                        System.out.println("BOOM!   You sunk the ship!");
                        countCShip--;
                    } else if ("@".equals(userBoard[x][y])) {
                        System.out.println("are you Stupid.You shot ur ship");
                        userBoard[x][y] = "x";
                        countUShip--;
                    } else {
                        System.out.println("You missed");
                        userBoard[x][y]="x";
                    }
                    printOut(gameBoard, userBoard, compBoard);
                    System.out.println("|User's ships:" + countUShip + " | Computer's ships :" + countCShip);
                }
            } else if (compTurn) {
                Random rand = new Random();
                int x = rand.nextInt(((10 - 1) + 1) + 1);
                int y = rand.nextInt(((10 - 1) + 1) + 1);
//                System.out.print("Enter X coordinate " + x);
//                System.out.print("Enter Y coordinate " + y);
                if (x >= 10 || y >= 10 || x < 0 || y < 0) {
//                    System.out.println("Enter valid Coordinate");
                } else {
                    System.out.println("Computer Turn :");
                    compTurn = false;
                    userTurn = true;
                    if ("@".equals(userBoard[x][y])) {
                        userBoard[x][y] = "x";
                        System.out.println("BOOM! Computer sunk your ship!");
                        printOut(gameBoard, userBoard, compBoard);
                        countUShip--;
                        System.out.println("|User's ships:" + countUShip + " | Computer's ships :" + countCShip);
                    } else if ("@".equals(compBoard[x][y])) {
                        System.out.println("Computer shot own ship :D:D");
                        countCShip--;
                        printOut(gameBoard, userBoard, compBoard);
                        System.out.println("|User's ships:" + countUShip + " | Computer's ships :" + countCShip);
                    } else {
                        System.out.println("Computer missed");
                    }
                }
            }
        }
    }
    private static void  printOut(String [][] gameBoard,String[][] userBoard,String [][]compBoard){
        System.out.println("   0123456789 ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (("@").equals(userBoard[i][j])){
                    gameBoard[i][j]="@";
                }else if("x".equals(userBoard[i][j])||"x".equals(compBoard[i][j])){
                    gameBoard[i][j]="x";
                }
                else
                    gameBoard[i][j] = " ";
                System.out.print(gameBoard[i][j]);
            }
            System.out.println("| " + i);
        }
        System.out.println("   0123456789 ");
    }
}