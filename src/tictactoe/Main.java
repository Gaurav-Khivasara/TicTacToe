//Against computer
//Choice X or O to the players
//Suggestions while 1v1
//First basic
//APPEND position for mistake

package tictactoe;

import java.util.Scanner;

public class Main {
	static char[] ttt = new char[9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pos, plyr, chance = 1;
		char j = '0';

		for (int i = 0; i < 9; i++) {
			ttt[i] = ++j;
		}

		System.out.println("Enter a position on your turn to put X or O\n");
		System.out.println("Positions are:\n1 | 2 | 3\n---------\n4 | 5 | 6\n---------\n7 | 8 | 9");
		System.out.println("\nPlayer 1 is 'X'\nPlayer 2 is 'O'");

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
				System.out.println("Enter valid position!");
			}

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