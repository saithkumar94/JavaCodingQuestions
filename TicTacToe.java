/* tic tac toe game implementation */

import java.util.Scanner;

public class TicTacToe {

  public static int row,col;
  public static Scanner sc = new Scanner(System.in);
  public static char board[][] = new char[3][3];
  public static char turn ='X';

  public static void main(String args[]){

    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
            board[i][j] = '_';
      }
    }

    printBoard();
    play();

  }

  public static void play(){

    boolean playing = true;

    while(playing){
      System.out.println("enter row : ");
      row = sc.nextInt()-1;
      System.out.println("enter column : ");
      col = sc.nextInt()-1;
      board[row][col] = turn;

      if(gameOver(row,col)){
          playing = false;
          System.out.println("Game Over! Player "+ turn + "Wins!!");
      }

      printBoard();
      if(turn == 'X'){
        turn = 'O';
      }
      else 
        turn = 'X';
    }


  }


  public static void printBoard(){

    for(int i=0;i<3;i++){
      System.out.println();
      for(int j=0;j<3;j++){
            if(j==0){System.out.print("| ");}
            System.out.print(board[i][j]+" | ");
      }
    }
    System.out.println();

  }

  public static boolean gameOver(int rmove, int cmove){
  // check perpendicular victory
    if(board[0][cmove] == board[1][cmove] && board[0][cmove] == board[2][cmove])
      return true;

    if(board[rmove][0] == board[rmove][1] && board[rmove][0] == board[rmove][2])
      return true;
  // check diagonal victory
    if(board[0][0] == board[1][1] && board[0][0] == board[2][2] &&  board[1][1]!= '_')
    return true;

    if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1]!= '_')
    return true;    

    return false;
  }  

}