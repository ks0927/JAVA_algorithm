import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		int max = 0;
		long total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int int1 = Integer.parseInt(st.nextToken());
				map[i][j] = int1;

				max = Math.max(max, int1);
				total += int1;
			}
		}

		int s = 1;
		int e = max;
		int m;

		while (s < e) {
			m = (s + e) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += (map[i][j] < m) ? map[i][j] : m;
				}
			}
			int ratio = (int) ((sum * 1.0 / total) * 100);

			if (ratio < 50) {
				s = m + 1;
			} else {
				e = m;
			}

		}

		System.out.println(e);

	}

}
