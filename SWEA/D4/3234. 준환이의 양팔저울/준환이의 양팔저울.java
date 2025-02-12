import java.util.*;
import java.io.*;

public class Solution {

	static int[] weight;
	static int[] nums;
	static boolean[] visited;
	static int N;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			weight = new int[N];
			nums = new int[N];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				weight[j] = value;
			}

			result = 0;
			perm(0);
			sb.append("#").append(i + 1).append(" ").append(result).append("\n");

		}

		System.out.print(sb);
	}

	private static void perm(int depth) {

		if (depth == N) {
			subset(0, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[depth] = weight[i];
			perm(depth + 1);
			visited[i] = false;
			nums[depth] = 0;
		}

	}

	private static void subset(int depth, int left, int right) {

		if (left < right)
			return;

		if (depth == N) {
			result++;
			return;
		}

		subset(depth + 1, left + nums[depth], right);
		subset(depth + 1, left, right + nums[depth]);
	}

}
