import java.util.Scanner;

public class Main {
	static int N;
	static int cnt;
	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		visited = new int[3][2 * N + 1];

		cnt = 0;
		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int depth) {
		if (depth == N) {
			cnt++;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("-----------------------");
			return;
		}

		for (int i = 0; i < N; i++) {

			int r = depth;
			int c = i;

			if (visited[0][c] == 1 || visited[1][r + c] == 1 || visited[2][r - c + N + 1] == 1) {
				continue;
			}

			map[r][c] = 1;
			visited[0][c] = 1;
			visited[1][r + c] = 1;
			visited[2][r - c + N + 1] = 1;
			dfs(depth + 1);
			map[r][c] = 0;
			visited[0][c] = 0;
			visited[1][r + c] = 0;
			visited[2][r - c + N + 1] = 0;
		}
	}

}
