//boolean mid as a member leke thoda chota ho skta hai
//****internal alag aur output alag user ko kind of chutiya banana, like a pointer points to a specific thing, connect internal and external

//*****har ek move k liye ek variable so max 9 variables!!!!******

//Position Function!!!!

package computer;

import java.util.Scanner;

public class ComputerMain {
	static char ttt[][] = new char[3][3], assign = '0';

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ttt[i][j] = ++assign;
			}
		}

		int chance = 1, pos = 0;

		System.out.println("Enter position on your turn\nPsitions are\n 1 | 2 | 3\n----------");
		System.out.print(" 4 | 5 | 6\n----------\n 7 | 8 | 9");

		while (chance < 10) {
			if (chance % 2 == 1) {
				System.out.print("\n\nPlayer: ");
				pos = sc.nextInt();
				if (pos > 0 && pos < 10) {
					if (isEmpty(pos)) {
						assign('X', pos);
						chance++;
					} else {
						System.out.println("Position already acquired!\n");
					}
				} else {
					System.out.println("Enter valid position!\n");
				}
			} else {
				pos = computerPosition(chance, pos);
				System.out.println("\n\nComputer: " + pos);
				assign('O', pos);
				chance++;
			}

			print();

			if (chance > 5 && check(chance - 1)) {
				chance = 10;
			}
		}
		
		sc.close();
	}

	static boolean check(int chance) {
		boolean winner = false;
		for (int i = 0; i < 3; i++) {
			if (ttt[0][i] == ttt[1][i] && ttt[2][i] == ttt[0][i]) {
				winner = true;
			} else if (ttt[i][0] == ttt[i][1] && ttt[i][2] == ttt[i][0]) {
				winner = true;
			}
		}
		
		if (!winner) {
			if (ttt[0][0] == ttt[1][1] && ttt[2][2] == ttt[0][0]) {
				winner = true;
			} else if (ttt[0][2] == ttt[1][1] && ttt[2][0] == ttt[0][2]) {
				winner = true;
			}
		}

		if (winner) {
			if (chance % 2 == 1) {
				System.out.println("\n\nGame Over!\nPlayer WINS!");
			} else {
				System.out.println("\n\nGame Over!\nComputer WINS!");
			}
		} else if (chance == 9) {
			System.out.println("\n\nGame Over!\nIt's a DRAW!");
			winner = true;
		}

		return winner;
	}

	static int computerPosition(int chance, int pos) {
		int rtn = 0;
		switch (chance) {
			case 2:
				if (pos != 5) {
					rtn = 5;
				} else {
					rtn = 1;
				}
			break;
			default:
				rtn = checkComputer();
				if (rtn == 0) {
					rtn = cornersMid();
				}
	
				if (ttt[0][0] == 'X' && ttt[2][2] == 'X' && chance == 4) {
					rtn = 2;
				}
				
				if (ttt[0][2] == 'X' && ttt[2][0] == 'X' && chance == 4) {
					rtn = 8;
				}
				
				if (ttt[0][0] == 'X' && ttt[2][1] == 'X' && chance == 4) {
					rtn = 7;
				}
				
				if (ttt[0][2] == 'X' && ttt[2][1] == 'X' && chance == 4) {
					rtn = 7;
				}
				
				if (ttt[1][2] == 'X' && ttt[2][0] == 'X' && chance == 4) {
					rtn = 9;
				}
				
				if (ttt[1][2] == 'X' && ttt[2][1] == 'X' && chance == 4) {
					rtn = 9;
				}
	
			break;
		}

		return rtn;
	}

	static int cornersMid() {
		for (int i = 1; i < 10; i += 2) {
			if (isEmpty(i)) {
				return i;
			}
		}
		
		for (int i = 2; i < 9; i += 2) {
			if (isEmpty(i)) {
				return i;
			}
		}
		
		return 0;
	}

	static int checkComputer() {
		char xo = 'O', ox = 'X';
		for (int j = 1; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				if (ttt[i][0] == xo && ttt[i][1] == xo && ttt[i][2] != ox) {
					if (isEmpty((i + 1) * 3)) {
						return (i + 1) * 3;
					}
				} else if (ttt[i][0] == xo && ttt[i][2] == xo && ttt[i][1] != ox) {
					if (isEmpty(((i + 1) * 3) - 1)) {
						return ((i + 1) * 3) - 1;
					}
				} else if (ttt[i][1] == xo && ttt[i][2] == xo && ttt[i][0] != ox) {
					if (isEmpty(3 * i + 1)) {
						return 3 * i + 1;
					}
				} else if (ttt[0][i] == xo && ttt[1][i] == xo && ttt[2][i] != ox) {
					if (isEmpty(i + 7)) {
						return i + 7;
					}
				} else if (ttt[0][i] == xo && ttt[2][i] == xo && ttt[1][i] != ox) {
					if (isEmpty(i + 4)) {
						return i + 4;
					}
				} else if (ttt[1][i] == xo && ttt[2][i] == xo && ttt[0][i] != ox) {
					if (isEmpty(i + 1)) {
						return i + 1;
					}
				}
			}
			
			if (ttt[0][0] == xo && ttt[1][1] == xo && ttt[2][2] != ox) {
				if (isEmpty(9)) {
					return 9;
				}
			} else if (ttt[0][0] == xo && ttt[2][2] == xo && ttt[1][1] != ox) {
				if (isEmpty(5)) {
					return 5;
				}
			} else if (ttt[1][1] == xo && ttt[2][2] == xo && ttt[0][0] != ox) {
				if (isEmpty(1)) {
					return 1;
				}
			} else if (ttt[1][1] == xo && ttt[0][2] == xo && ttt[2][0] != ox) {
				if (isEmpty(7)) {
					return 7;
				}
			} else if (ttt[1][1] == xo && ttt[2][0] == xo && ttt[0][2] != ox) {
				if (isEmpty(3)) {
					return 3;
				}
			} else if (ttt[0][2] == xo && ttt[2][0] == xo && ttt[1][1] != ox) {
				if (isEmpty(1)) {
					return 1;
				}
			}
			
			xo = 'X';
			ox = 'O';
		}
		
		return 0;
	}

	static void assign(char xo, int pos) {
		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (pos == i + j + k) {
					ttt[i][j] = xo;
				}
			}
			
			k += 2;
		}
	}

	static void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + ttt[i][j]);
				if (j < 2) {
					System.out.print(" |");
				}
			}
			
			if (i < 2) {
				System.out.println("\n-----------");
			}
		}
	}

	static boolean isEmpty(int pos) {
		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ttt[i][j] != 'X' && ttt[i][j] != 'O' && pos == k + i + j) {
					return true;
				}
			}
			
			k += 2;
		}
		
		return false;
	}
}
