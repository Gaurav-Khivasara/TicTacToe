package computer;

import java.util.Scanner;

public class _incomplete_Computer1DArray {
	static char ttt[]=new char[9], assign='0';
	static int rtn=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int j, pos=0, chance=1;
		
		for(int i=0; i<9; i++)
			ttt[i]=++assign;
		
		System.out.println("Enter position on your turn\n\nPositions are: ");
		print();
		while(chance<10) {
			if(chance%2==1) {
				System.out.print("\nPlayer (X): ");
				pos=sc.nextInt();
				if(pos>=1 || pos<=9) {
					if(ifEmpty(pos)) {
						ttt[pos-1]='X';
						chance++;
					}
					else
						System.out.println("Position already acquired!");
				}
				else
					System.out.print("Enter valid position!");
			}
			else {
				pos=computer(chance, pos);
				System.out.println("\nComputer (O): "+pos);
				ttt[pos-1]='O';
				chance++;
			}
	
			print();
		}
		
		sc.close();
	}
	
	static int computer(int chance, int pos) {
		switch(chance) {
		case 2:rtn=5;
			if(pos==5)
				rtn=1;
			break;
		case 4:
			if(rtn==5)
				if(pos==1 || pos==3 || pos==7 || pos==9)
					rtn=10-pos;
				else
					rtn=1;
			else
				if(pos==9)
					rtn=3;
				else
					rtn=10-pos;
			break;
		
		}
		return rtn;
	}
	
	static boolean ifEmpty(int pos) {
		if(ttt[pos-1]!='X' && ttt[pos-1]!='O') 
			return true;
		else
			return false;
	}
	
	static void print() {
		int k=0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(ttt[k++]);
				if(j<2)
					System.out.print(" | ");
			}
			if(i<2)
				System.out.println("\n---------");
		}
		System.out.println();
	}
}