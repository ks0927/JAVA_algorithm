import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		// 랄파
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < m; j++) {
			int value = Integer.parseInt(st.nextToken());
			map[0][j] = value;
		}

		int vaild = ((n-1) % 2 == 0) ? (n - 1) / 2 : (n - 1) / 2 + 1;

		int cnt = 0;
		// 나머지
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int sum = 0;
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;

				sum += Math.abs(value - map[0][j]);

				if (sum > 2000) {
					cnt++;
				}

				if (cnt >= vaild) {
					System.out.println("YES");
					return;
				}
			}

		}

		System.out.println("NO");
	}

}
