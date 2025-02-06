package tictactoe;

public class Utility {
	public static final String RESET = "\033[0m";
	public static final String BRIGHT_YELLOW = "\033[1;33m";
	public static final String BRIGHT_CYAN = "\033[1;36m";
    public static final String BRIGHT_WHITE = "\033[1;37m";
    public static final String BRIGHT_GREEN = "\033[1;32m";
    public static final String BRIGHT_RED = "\033[1;31m";
	
	public static int checker(char arr[], char xo) {
		for (int i = 0; i < 7; i += 3) {
			if (i == 0) {
				if (arr[0] == xo && arr[4] == xo && arr[8] == xo) {
					return returnP(xo);
				} else if (arr[2] == xo && arr[4] == xo && arr[6] == xo) {
					return returnP(xo);
				}
			}
			
			if (arr[i] == xo && arr[i + 1] == xo && arr[i + 2] == xo) {
				return returnP(xo);
			}
			
			if (arr[i / 3] == xo && arr[i / 3 + 3] == xo && arr[i / 3 + 6] == xo) {
				return returnP(xo);
			}
		}

		return 0;
	}
	
	private static int returnP(char xo) {
		return xo == 'X' ? 1 : 2;
	}

	public static void printArr(char arr[]) {
		System.out.print(Utility.RESET);
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[k] == 'X') {
					System.out.print(Utility.BRIGHT_YELLOW);
				} else if (arr[k] == 'O') {
					System.out.print(Utility.BRIGHT_CYAN);
				}
				
				System.out.print(arr[k++] + " ");
				
				if (j < 2) {
					System.out.print(Utility.BRIGHT_WHITE + "| ");
				}
			}
			
			System.out.print("\n");
			if (i != 2) {
				System.out.print(Utility.BRIGHT_WHITE + "---------\n");
			}
		}
		System.out.print(Utility.RESET);
	}

	public static void switchPlayers(char arr[], int p, char xo) {
		int i = 0;
		while (i + 1 != p) {
			i++;
		}
		arr[i] = xo;
	}
}
