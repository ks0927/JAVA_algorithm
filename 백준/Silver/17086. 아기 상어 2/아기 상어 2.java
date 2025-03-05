import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<int[]> sharks;
	static int max;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		sharks = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == 0) {
					queue.add(new int[] { i, j });
				}
				if (value == 1) {
					sharks.add(new int[] { i, j });
				}
			}
		}
		
		max = 0;
		for (int[] safe : queue) {
			distance(safe);
		}
		
		System.out.println(max);
	}
	private static void distance(int[] safe) {
		
		int r1 = safe[0];
		int c1 = safe[1];
		
		int min  = 25000;
		for (int[] shark : sharks) {
			int r2 = shark[0];
			int c2 = shark[1];
			
			int span = Math.max(Math.abs(r1-r2), Math.abs(c1-c2));
			if(min > span) {
				min = span;
			}

		}
		if(max < min) {
			max = min;
		}
	}

}
