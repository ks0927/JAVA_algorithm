import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] nums;
	static boolean[] visited;
	static int min;
	static int N;
	static int cx;
	static int cy;
	static int hx;
	static int hy;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());

			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[j][0] = x;
				map[j][1] = y;
			}
			min = Integer.MAX_VALUE;
			nums = new int[N];
			visited = new boolean[N];
			perm(0,0);
			sb.append("#").append(i+1).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}

	private static void perm(int depth,int total) {
		if(min < total) {
			return;
		}
		
		if (depth == N) {
			int sum = total;

			sum += Math.abs(map[nums[N - 1]][0] - hx);
			sum += Math.abs(map[nums[N - 1]][1] - hy);

			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[depth] = i;
			if(depth == 0) {
				perm(depth + 1, total + Math.abs(map[nums[0]][0] - cx) + Math.abs(map[nums[0]][1] - cy));
			}else {
				perm(depth + 1,total + Math.abs(map[nums[depth]][0] - map[nums[depth - 1]][0]) + Math.abs(map[nums[depth]][1] - map[nums[depth - 1]][1]));
			}
			visited[i] = false;
			nums[depth] = 0;
		}
	}

}
