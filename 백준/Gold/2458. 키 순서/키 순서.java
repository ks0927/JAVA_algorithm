import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int cnt;
	static boolean[] visited;
	static int[] cnts;
	static ArrayList<Integer>[] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int child = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());

			map[child].add(parent);
		}

		cnts = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			cnt = 0;
			dfs(i);
//			System.out.println(Arrays.toString(cnts));
			cnts[i] += cnt;
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (cnts[i] == N - 1)
				result++;
		}

		System.out.println(result);
	}

	private static void dfs(int node) {
		if (map[node].isEmpty())
			return;

		for (int parent : map[node]) {
			if (!visited[parent]) {
				visited[parent] = true;
				cnt++;
				cnts[parent] += 1;
				dfs(parent);
			}
		}

	}

}
