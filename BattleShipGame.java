import java.util.*;

class BattleShipGame {
  

  public static char guessboard[][] = new char[6][6];
  public static char battleboard[][] = new char[6][6];
  public static Scanner sc = new Scanner(System.in);
  public static int[] battle_start_arr = new int[2];
  public static int[] battle_end_arr = new int[2];
  public static int guesses = 10;
  

  public static void play(){
    System.out.println("We are in Play Method");
    System.out.println("-----------------------");
    System.out.println("Enter the coordinates for Battleship for Player 1");
    System.out.println("Enter the start coordinates");
    String start = sc.nextLine();
    System.out.println("Enter the end coordinates");
    String end = sc.nextLine();

    int[] start_arr = getRownCol(start);
    int[] end_arr = getRownCol(end);
    battle_start_arr = Arrays.copyOf(start_arr, 2);
    battle_end_arr = Arrays.copyOf(end_arr, 2);
    /*
    System.out.println("Starting Array is "+ battle_start_arr[0]+ " "+battle_start_arr[1]);
    System.out.println("Ending array is :"+ battle_end_arr[0]+" "+ + battle_end_arr[1]);
    */
    for(int i=start_arr[0];i<=end_arr[0];i++){
      for(int j=start_arr[1];j<=end_arr[1];j++){
          battleboard[i][j] = 'X';
      }
    }

    showboard(battleboard);

    guessboardplay();

  }

  public static void guessboardplay(){
    System.out.println("We are in guessboardplay");
    System.out.println("-------------------------");
    boolean flag = false;
    int row,col;

    if(guesses < 10){
      System.out.println("Enter your guess :");
      String guess = sc.nextLine();

      int[] guess_arr = getRownCol(guess);

      row = guess_arr[0];
      col = guess_arr[1];

      guessboard[row][col] = 'O';

      flag = guessboardcheck();

      if(flag == true){
        System.out.println("Congrats you found the battleship");
        showboard(guessboard);
        return;
      }

      guesses--;
    }

  }


  public static boolean guessboardcheck(){
    boolean flag = false;
    for(int i=battle_start_arr[0];i<=battle_end_arr[0];i++){
      for(int j=battle_start_arr[1];j<=battle_end_arr[1];j++){
          if(guessboard[i][j] == battleboard[i][j])
            flag = true; 
          else
            flag = false;
      }
    }
    return flag;
  }

  public static int[] getRownCol(String str){

    System.out.println("We are in getRownCol Method");
    System.out.println("-----------------------");

    char row;
    int col;
    int cord[] = new int[2];

    if(str == null){
      System.out.println("Invalid input string");
      return null;
    }
    row = str.charAt(0);
    cord[0] = getRowNo(row);
    col = Integer.parseInt(str.replaceAll("[\\D]", ""));
    //System.out.println("Column is " + col);
    cord[1] = col -1;
    //System.out.println("Row and col are in cord are "+cord[0] + " "+ cord[1]);

    return cord;
  }

  public static int getRowNo(char c){

    System.out.println("We are in getRowNo Method");
    System.out.println("-----------------------");    
    int row =0;

    if(c == ' '){
      System.out.println("Invalid Row character");
      return 0;
    }

    switch (c) {
    case 'A':
    row =0;
    break;
    case 'B':
    row =1;
    break;
    case 'C':
    row =2;
    break;
    case 'D':
    row =3;
    break;
    case 'E':
    row =4;
    break;
    case 'F':
    row =5;
    break;
    }

    //System.out.println("Row letter to integer is "+ c + " : " + row);
    return row;
  }


  public static void showboard(char[][] board){


    for(int i=0; i<6;i++){
      System.out.println();
      for(int j=0;j<6;j++){
         System.out.print(board[i][j]);
      }
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        guessboard[i][j] = '.';
        battleboard[i][j] = '.';
      }
    }
    System.out.println("Player 2 board is :");
    showboard(guessboard);
    System.out.println("Player 1 board is :");
    showboard(battleboard);
    play();

  }
}