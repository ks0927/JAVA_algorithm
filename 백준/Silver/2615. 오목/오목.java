import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static boolean find = false;
	static int R;
	static int C;

	// 오른쪽 위, 오른쪽, 오른쪽아래, 아래 (4방 탐색)
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				int value = Integer.parseInt(st.nextToken());
				board[i][j] = value;
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {

				if (find) {
					System.out.println(board[R][C]);
					System.out.println((R + 1) + " " + (C + 1));
					return;
				}
				
				if (board[j][i] != 0) { //빈칸이 아닌 돌을 찾았을때
					checkWin(j, i);
				}
			}
		}

		System.out.println(0);

	}

	public static void checkWin(int r, int c) {
		int color = board[r][c];

		for (int i = 0; i < 4; i++) {
			int count = 1;

			int tr = r;
			int tc = c;
			while (count != 5) {

				tr += dr[i];
				tc += dc[i];

				if (!(tr >= 0 && tr < 19 && tc >= 0 && tc < 19))
					break;

				if (board[tr][tc] != color) {
					break;
				} else {
					count++;
				}
			}

			if (count == 5) { // 5개를 찾았을때
				// 맨처음의 뒤쪽 칸을 체크해본다.
				int firstTr = r - dr[i];
				int firstTc = c - dc[i];
				
				//만약 맨처음의 뒤쪽 칸이 막혀있거나 같은색이 아니라면 마지막의 다음칸을 체크해본다. 
				if (!(firstTr >= 0 && firstTr < 19 && firstTc >= 0 && firstTc < 19) || board[firstTr][firstTc] != color) {
					//다음칸을 체크해본다.
					int lastTr = tr + dr[i];
					int lastTc = tc + dc[i];

					// 만약 다음칸이 없다면 오목 성공
					if (!(lastTr >= 0 && lastTr < 19 && lastTc >= 0 && lastTc < 19)) {
						find = true;
						R = r;
						C = c;
						return;
					} else {// 다음칸이 있지만 뚫려있거나 다른색이면 오목 성공
						if (board[lastTr][lastTc] != color) {
							find = true;
							R = r;
							C = c;
							return;
						} // else의 경우는 육목
					}
				}

			}

		}

	}
}
