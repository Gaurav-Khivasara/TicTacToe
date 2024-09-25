package tictactoe;

import java.util.Scanner;

public class Computer {
	private static char ttt[] = new char[9];
	int rtn = 0;

	public void computer(char[] ttt) {
		Computer.ttt = ttt;
		
		Scanner sc = new Scanner(System.in);

		int chance = 1, pos = 0;

		System.out.println("\nPlayer 1 is 'X'\nComputer is 'O'");
		System.out.println("\nEnter a position on your turn to put X or O");
		System.out.println("Positions are:");
		Utility.printArr(ttt);

		while (chance < 10) {
			if (chance % 2 == 1) {
				System.out.print("\n\nPlayer: ");
				pos = sc.nextInt();
				if (pos > 0 && pos < 10) {
					if (isEmpty(pos)) {
						ttt[pos - 1] = 'X';
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
				ttt[pos - 1] = 'O';
				chance++;
			}

			Utility.printArr(ttt);

			int checker = Utility.checker(ttt, returnP(chance - 1));
			if (chance > 5 && checker == 1) {
				System.out.println("\n\nGame Over!\nPlayer WINS!");
				break;
			} else if (chance > 5 && checker == 2) {
				System.out.println("\n\nGame Over!\nComputer WINS!");
				break;
			} else if (chance == 10) {
				System.out.println("\n\nGame Over!\nIt's a DRAW!");
			}
		}
		
		sc.close();
	}
	
	private char returnP(int chance) {
		return chance % 2 == 1 ? 'X' : 'O';
	}

	private int computerPosition(int chance, int pos) {
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
	
				if (ttt[0] == 'X' && ttt[8] == 'X' && chance == 4) {
					rtn = 2;
				}
				
				if (ttt[2] == 'X' && ttt[6] == 'X' && chance == 4) {
					rtn = 8;
				}
				
				if (ttt[0] == 'X' && ttt[7] == 'X' && chance == 4) {
					rtn = 7;
				}
				
				if (ttt[2] == 'X' && ttt[7] == 'X' && chance == 4) {
					rtn = 7;
				}
				
				if (ttt[5] == 'X' && ttt[6] == 'X' && chance == 4) {
					rtn = 9;
				}
				
				if (ttt[5] == 'X' && ttt[7] == 'X' && chance == 4) {
					rtn = 9;
				}
			break;
		}

		return rtn;
	}

	private int cornersMid() {
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

	private int checkComputer() {
		char xo = 'O', ox = 'X';
		for (int j = 1; j < 3; j++) {
			for (int i = 0; i < 7; i += 3) {
				if (ttt[i] == xo && ttt[i + 1] == xo && ttt[i + 2] != ox) {
					if (isEmpty(i + 3)) {
						return i + 3;
					}
				} else if (ttt[i] == xo && ttt[i + 2] == xo && ttt[i + 1] != ox) {
					if (isEmpty(i + 2)) {
						return i + 2;
					}
				} else if (ttt[i + 1] == xo && ttt[i + 2] == xo && ttt[i] != ox) {
					if (isEmpty(i + 1)) {
						return i + 1;
					}
				}
			}
			
			for (int i = 0; i < 3; i++) {
				if (ttt[i] == xo && ttt[i + 3] == xo && ttt[i + 6] != ox) {
					if (isEmpty(i + 7)) {
						return i + 7;
					}
				} else if (ttt[i] == xo && ttt[i + 6] == xo && ttt[i + 3] != ox) {
					if (isEmpty(i + 4)) {
						return i + 4;
					}
				} else if (ttt[i + 3] == xo && ttt[i + 6] == xo && ttt[i] != ox) {
					if (isEmpty(i + 1)) {
						return i + 1;
					}
				}
			}
			
			if (ttt[0] == xo && ttt[4] == xo && ttt[8] != ox) {
				if (isEmpty(9)) {
					return 9;
				}
			} else if (ttt[0] == xo && ttt[8] == xo && ttt[4] != ox) {
				if (isEmpty(5)) {
					return 5;
				}
			} else if (ttt[4] == xo && ttt[8] == xo && ttt[0] != ox) {
				if (isEmpty(1)) {
					return 1;
				}
			} else if (ttt[4] == xo && ttt[2] == xo && ttt[6] != ox) {
				if (isEmpty(7)) {
					return 7;
				}
			} else if (ttt[4] == xo && ttt[6] == xo && ttt[2] != ox) {
				if (isEmpty(3)) {
					return 3;
				}
			} else if (ttt[2] == xo && ttt[6] == xo && ttt[4] != ox) {
				if (isEmpty(1)) {
					return 1;
				}
			}
			
			xo = 'X';
			ox = 'O';
		}
		
		return 0;
	}

	private boolean isEmpty(int pos) {
		return ttt[pos - 1] != 'X' && ttt[pos - 1] != 'O';
	}
}
