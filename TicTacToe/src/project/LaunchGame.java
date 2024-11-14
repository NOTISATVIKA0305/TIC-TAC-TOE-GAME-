package project;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	static char[][] board;

	public TicTacToe() {
		// TODO Auto-generated constructor stub
		board=new char[3][3];
		initBoard();
	}
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
		
	}
	void display() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("-------------");

		}
	}
	static void mark(int row,int col,char markplace) {
		if(row>=0 && row<=2 && col >=0 && col<=2) {
			board[row][col]=markplace;
		}
		else {
			System.out.print("YOU ENTERED WORNG INPUT");
		}
		
	}
	static boolean colWin() {
		for(int j=0;j<=2;j++) 
		{
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) 
			{
				return true;
			}
		}
		return false;
		
	}
	static boolean rowWin() {
		for(int i=0;i<=2;i++)
		{
			if( board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) 
			{
				return true;
			}
		}
			return false;
	}
	static boolean diaWin() {
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			return true;
		}
		return false;

		
	}
}
abstract class Player{
	String name;
	char c;
	
	abstract void makeMove();
	boolean checkVaild(int rownu,int colnu) {
		if(rownu>=0 && rownu<=2  && colnu>=0 &&colnu<=2  && TicTacToe.board[rownu][colnu]==' ') {
			return true;
			
		}else {
			return false;
		}
	}
	
}
	
class Human extends Player {
		
		public Human(String name, char c) {
			super();
			this.name = name;
			this.c = c;
		}
		
		void makeMove() {
			Scanner sc=new Scanner(System.in);
			int rownu;
			int colnu;
			do {
				System.out.println("Enter the Row and Col");
				rownu=sc.nextInt();
				colnu=sc.nextInt();
			}
			while(!checkVaild(rownu,colnu)) ;
				TicTacToe.mark(rownu, colnu, c);
			
			
		}
		
		
		
	}
class AI extends Player {
	public AI(String name, char c) {
		super();
		this.name = name;
		this.c = c;
	}
	
	void makeMove() {
		Scanner sc=new Scanner(System.in);
		int rownu;
		int colnu;
		do {
			Random r=new Random();
			rownu=r.nextInt(3);
			colnu=r.nextInt(3);
		}
		while(!checkVaild(rownu,colnu)) ;
			TicTacToe.mark(rownu, colnu, c);
		
		
	}
	
	
}

public class LaunchGame{
	public static void main(String[] args) 
	{
		TicTacToe t=new TicTacToe();
		Human p1=new Human("Raju",'x');
		AI p2=new AI("AI",'O');
	    Player cp;
		cp=p1;
		while(true) {
		System.out.println(cp.name+"turn");
		cp.makeMove();
		t.display();
		if(TicTacToe.colWin() || TicTacToe.rowWin() ||TicTacToe.diaWin()) {
			System.out.println(cp.name+" has won");
			break;
		}
		else {
			if(cp==p1) {
				cp=p2;
				
			}
			else {
				cp=p1;
			}
			
		}
		}
	
		
		
		

		
		
	}
}

