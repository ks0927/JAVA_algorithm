import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	static int[][] map;
	static int[] items;
	static final int INF = 10000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		items = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s][e] = w;
			map[e][s] = w;
		}

		int[][] fw = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				fw[i][j] = INF;
				if (map[i][j] != 0) {
					fw[i][j] = map[i][j];
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					fw[i][j] = Math.min(fw[i][k] + fw[k][j], fw[i][j]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if(i == j) {
					sum += items[j];
					continue;
				}
				
				if(fw[i][j] <= M) {
					sum += items[j];
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
