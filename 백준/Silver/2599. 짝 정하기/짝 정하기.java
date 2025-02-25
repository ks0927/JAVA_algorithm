import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean check;
	static boolean[] visited;
	static int[][] map;
	static int[] nums;
	static String[] combi = { "0011", "0021", "1001", "1021", "2001", "2011" };
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[3][2];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = false;
		visited = new boolean[6];
		nums = new int[6];
		perm(0, N + N);
		
		if(!check) {
			System.out.println(0);
		}else {
			System.out.print(sb);
		}
		
	}

	private static void perm(int depth, int total) {
		if(check)
			return;
		
		if (depth == 6) {
			if(total == 0) {
				check = true;
				sb.append(1).append("\n");
				sb.append(nums[0]).append(" ").append(nums[1]).append("\n");
				sb.append(nums[2]).append(" ").append(nums[3]).append("\n");
				sb.append(nums[4]).append(" ").append(nums[5]).append("\n");
			}
			
			return;
		}

		for (int i = 0; i < 6; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			int a = combi[i].charAt(0) - '0';
			int b = combi[i].charAt(1) - '0';
			int c = combi[i].charAt(2) - '0';
			int d = combi[i].charAt(3) - '0';

			int boy = map[a][b];
			int girl = map[c][d];
			int min = Math.min(boy, girl);
			nums[i] = min;
			map[a][b] -= min;
			map[c][d] -= min;
			
			perm(depth + 1, total - min - min);
			
			visited[i] = false;
			nums[i] = 0;
			map[a][b] += min;
			map[c][d] += min;
			

		}
	}

}
