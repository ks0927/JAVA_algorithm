import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<Integer> people;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		people = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				int value = str.charAt(j) - '0';
				map[i][j] = value;
			}
		}

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					BFS(i, j, cnt);
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(cnt - 1);
		Collections.sort(people);
		for (Integer person : people) {
			System.out.println(person);
		}
	}

	public static void BFS(int cr, int cc, int g) {

		int human = 1;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { cr, cc });
		map[cr][cc] = g;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1) {
					que.offer(new int[] { nr, nc });
					map[nr][nc] = g;
					human++;
				}
			}
		}
		people.add(human);
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
