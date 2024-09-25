package tictactoe;

public class Utility {
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
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[k++] + " ");
				if (j < 2) {
					System.out.print("| ");
				}
			}
			
			System.out.print("\n");
			if (i != 2) {
				System.out.print("---------\n");
			}
		}
	}

	public static void switchPlayers(char arr[], int p, char xo) {
		int i = 0;
		while (i + 1 != p) {
			i++;
		}
		arr[i] = xo;
	}
}
