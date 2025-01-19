import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	static StringBuilder sb;
	
 	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		board = new int[N][N];
		
		sb = new StringBuilder();
		
		star(0,0,N); // 0,0 에서 길이 N
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j]== 1) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
 	}


	public static void star(int r, int c, int n) {
		
		if(n == 3) { //최소 크기를 n=3 일때로 잡음
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i== 1&& j==1) continue; //가운데를뚫어요
					board[r+i][c+j] = 1;
				}
			}
		}else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(i== 1&& j==1) continue;
						star(r+i*n/3,c+j*n/3,n/3);
					}
				}
			}


	}
	
}
