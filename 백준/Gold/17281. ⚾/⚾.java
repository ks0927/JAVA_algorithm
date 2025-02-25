import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] playerScores;
	static int[] nums;
	static int[] playerOrders;
	static int max;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		playerScores = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				playerScores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		nums = new int[9];
		playerOrders = new int[9];
		visited = new boolean[9];
		perm(0);
		System.out.println(max);
	}

	private static void perm(int depth) {
		if (depth == 8) {
			playerOrders[0] = nums[0];
			playerOrders[1] = nums[1];
			playerOrders[2] = nums[2];
			for (int i = 8; i > 3; i--) {
				playerOrders[i] = nums[i - 1];
			}
			playerOrders[3] = 0;
//			System.out.println(Arrays.toString(playerOrders));

			playBaseball();
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[depth] = i;
			perm(depth + 1);
			visited[i] = false;
			nums[depth] = 0;

		}

	}

	private static void playBaseball() {

		int index = -1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int outCount = 0;
			int ru = 0;
			while (true) {
				if (outCount == 3) {
					break;
				}
				index = (index + 1) % 9;
				int player = playerOrders[index];
				int hit = playerScores[i][player];

				if(hit == 0) {
					outCount++;
					continue;
				}
				ru = (ru << hit) | (1 << (hit - 1));

				for (int j = 3; j < 8; j++) {
					int check = 1 << j;

					if ((ru & check) != 0) {
						sum++;
						ru = ru ^ check;
					}
				}
			}
		}

		max = Math.max(max, sum);
	}

}
