package tictactoe;

import java.util.Scanner;

public class Main {
	private static char[] ttt = new char[9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pos, plyr, chance = 1;
		char j = '0';

		for (int i = 0; i < 9; i++) {
			ttt[i] = ++j;
		}
		
		int ch = 0;
		while (ch == 0) {
			System.out.println("1. vs Computer");
			System.out.println("2. Two Players");
			System.out.print("Enter your choice (1 or 2): ");
			ch = sc.nextInt();
			
			if (ch != 1 && ch != 2) {
				System.out.println("\nInvalid choice!\n");
				ch = 0;
			}
		}
		
		if (ch == 1) {
//			char[][] temp = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
//			new Computer2D().computer(temp);
			
			new Computer().computer(ttt);
			
			sc.close();
			return;
		}

		System.out.println("\nPlayer 1 is 'X'\nPlayer 2 is 'O'");
		System.out.println("\nEnter a position on your turn to put X or O");
		System.out.println("Positions are:");
		Utility.printArr(ttt);

		while (chance <= 9 && chance > 0) {
			plyr = 1;
			if (chance % 2 == 0) {
				plyr++;
			}

			System.out.print("\nPlayer " + plyr + " turn: ");
			pos = sc.nextInt();

			if (pos > 0 && pos < 10) {
				if (ttt[pos - 1] == 'X' || ttt[pos - 1] == 'O') {
					System.out.println("Position already occupied!!");
				} else {
					chance++;
					if (plyr == 1) {
						Utility.switchPlayers(ttt, pos, 'X');
					} else {
						Utility.switchPlayers(ttt, pos, 'O');
					}
				}
			} else {
				System.out.println("Enter valid position!\n");
			}
			
			Utility.printArr(ttt);


			if (Utility.checker(ttt, 'X') == 1) {
				System.out.println("\nPlayer 1 WON!!");
				break;
			} else if (Utility.checker(ttt, 'O') == 2) {
				System.out.println("\nPlayer 2 WON!!");
				break;
			} else if (Utility.checker(ttt, 'O') == 0 && chance == 10) {
				System.out.println("\nDraw!!\nGame Over!!");
				break;
			}
		}
		
		sc.close();
	}
}
