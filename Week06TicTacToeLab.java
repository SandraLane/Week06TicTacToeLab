package week06;
import java.util.Scanner;

public class Week06TicTacToeLab {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create an array for gameBoard	
			char [][] gameBoard = new char[3][3]; 		
		
		//Initialize the board 
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				gameBoard[i][j]= '-';
			}
		}
		
		//Create scanner so that you
		Scanner in = new Scanner(System.in);
		System.out.println("Let's play Tic Tac Toe!");
		System.out.print("Player 1, what is your name? ");
		String p1 = in.nextLine();
		System.out.print("Player 2, what is your name? ");
		String p2 = in.nextLine();
		
		boolean player1 = true;
		boolean gameOver = false;
		while(!gameOver) {
			drawBoard(gameBoard);
		
		if(player1) {
			System.out.println(p1 + "'s Turn (x):");
		} else {
			System.out.println(p2 + "'s Turn (o):");
		}
		//char variable that stores x or o
		char c = '-';
		if(player1) {
			c = 'x';
		} else {
			c = 'o';
		}
		//create row and column variables that represent indexes of where we're at on board
		int row = 0;
		int col =0;
		
		//while the user does not enter a valid position
		
		while(true) {
			//ask for position user wants to play on board
			
			System.out.print("Enter a row number (0, 1, or 2): ");
			row = in.nextInt();
			System.out.print("Enter a column number (0, 1, or 2): ");
			col = in.nextInt();
			
			//check if valid position
			
			if(row<0 || col<0 || row>2 || col>2) {
				System.out.println("This is not a valid position! Try again");
				//check if position is open
			} else if(gameBoard[row][col]!='-') {
				System.out.println("Someone already made a move at this position");
				
			} else {
				break;
			}
		}
		//sets position column and row to c
		gameBoard[row][col]=c;
		
		if(playerHasWon(gameBoard) == 'x') {
			System.out.println(p1 + " has won!");
			gameOver = true;
		} else if(playerHasWon(gameBoard) == 'o') {
			System.out.println(p2 + " has won!");
			gameOver = true;
		} else {
			//check to see if board is full and no one has won
			if(isBoardFull(gameBoard)) {
				System.out.println("It's a tie!");
				gameOver = true;
			} else {
				//If player1 is true, make it false, and vice versa; this way, the players alternate each turn
			player1 = !player1;
			}
		}
		
		}
	//draw final game board
			drawBoard(gameBoard);
}

	
						//Method drawBoaard
		
		private static void drawBoard(char[][]gameBoard) {
			System.out.println("Game Board:");
			for(int i=0;i<3;i++) {
				for(int j=0; j<3; j++) {
					System.out.print(gameBoard[i][j]);
				}
				System.out.println();
			}
		}
		//Method to see if someone has won and return the winning char
		
		public static char playerHasWon(char[][] gameBoard) {
			
			//Check each row
			for(int i = 0; i < 3; i++) {
				if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != '-') {
					return gameBoard[i][0];
				}
			}
			//check columns
			for(int j = 0; j < 3; j++) {
				if(gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j] && gameBoard[0][j] != '-') {
					return gameBoard[0][j];
				}
			}
			//check diagonals
			if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != '-') {
				return gameBoard[0][0];
			}
			if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] ==  gameBoard[0][2] && gameBoard[2][0] != '-') {
				return gameBoard[2][0];
			}
			//else nobody has won
			return ' ';
		}
		//make a method to see if board is full
		
		public static boolean isBoardFull(char[][] gameBoard) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(gameBoard[i][j] == '-') {
						return false;
					}
				}
			}
			return true;
		}
		
		}	

	

	

	


