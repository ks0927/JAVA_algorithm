import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int result;
	static int length;
	static int[] dr = { 0, 0, 1 }; // 좌 우 아래
	static int[] dc = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());

			map = new int[100][100];

			ArrayList<Integer> start = new ArrayList<>();
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 100; j2++) {
					int value = Integer.parseInt(st.nextToken());
					map[j][j2] = value;
					if (j == 0 && value == 1) {
						start.add(j2);
					}
				}
			}

			length = 100000;
			for (Integer index : start) {
				move(index);
			}

			sb.append("#").append(i).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void move(int index) {
		int r = 0;
		int c = index;

		int sum = 1;
		while (r < 100) {
			if(sum > length)
				return;
			int lc = c + dc[0];
			if (check(lc) && map[r][lc] == 1) {
				while (true) {
					int nc = c + dc[0];
					if (check(nc)) {
						if (map[r][nc] == 0)
							break;
						c = nc;
						sum++;
						if(sum > length)
							return;
//						System.out.println("r : " + r + " c : " + c);
					} else {
						break;
					}
				}
				r++;
				sum++;
				continue;
			}

			int rc = c + dc[1];
			if (check(rc) && map[r][rc] == 1) {
				while (true) {
					int nc = c + dc[1];
					if (check(nc)) {
						if (map[r][nc] == 0)
							break;
						c = nc;
						sum++;
						if(sum > length)
							return;
//						System.out.println("r : " + r + " c : " + c);
					} else {
						break;
					}
				}
				r++;
				sum++;
				continue;
			}
			r++;
			sum++;
		}
		if (sum < length) {
			length = sum;
			result = index;
		}

	}

	private static boolean check(int c) {
		return c >= 0 && c < 100;
	}

}
