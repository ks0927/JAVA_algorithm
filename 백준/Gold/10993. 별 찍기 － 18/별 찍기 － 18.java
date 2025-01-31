import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[(int) Math.pow(2, N) - 1][(int) Math.pow(2, N + 1) - 3];

		boolean flag = (N % 2 == 0) ? true : false; // true면 역삼각
		star(0, 0, N, flag);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					sb.append(" ");
				if (arr[i][j] == 1)
					sb.append("*");

			}

			// 오른쪽 빈공간 제거
			while (String.valueOf(sb.charAt(sb.length() - 1)).equals(" ")) {
				sb.deleteCharAt(sb.length() - 1);
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}

	public static void star(int r, int c, int N, boolean flag) {

		if (N == 0) {
			return;
		}
		// 역삼각형 이면
		if (flag) {
			for (int i = 0; i < (int) Math.pow(2, N) - 1; i++) {

				if (i == 0) {
					for (int j = 0; j < (int) Math.pow(2, N + 1) - 3; j++) {
						arr[r][c + j] = 1;
					}
				} else {
					arr[r + i][c + i] = 1;
					arr[r + i][c + (int) Math.pow(2, N + 1) - 3 - i - 1] = 1;
				}

			}
			flag = false;
			star(r + 1, c + (int) Math.pow(2, N - 1), N - 1, flag);
		} else {

			for (int i = 0; i < (int) Math.pow(2, N) - 1; i++) {

				if (i == (int) Math.pow(2, N) - 2) {
					for (int j = 0; j < (int) Math.pow(2, N + 1) - 3; j++) {
						arr[r + i][c + j] = 1;
					}
				} else {
					arr[r + i][c + ((int) Math.pow(2, N + 1) - 3 - 1) / 2 - i] = 1;
					arr[r + i][c + ((int) Math.pow(2, N + 1) - 3 - 1) / 2 + i] = 1;
				}

			}
			flag = true;
			star(r + ((int) Math.pow(2, N)) / 2 - 1, c + (int) Math.pow(2, N - 1), N - 1, flag);
		}
	}

}
