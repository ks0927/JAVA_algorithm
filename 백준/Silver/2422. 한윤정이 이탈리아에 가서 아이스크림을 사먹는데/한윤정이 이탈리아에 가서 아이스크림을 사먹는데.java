import java.util.*;
import java.io.*;

public class Main {

	static int N,M;
	static int[][] map;
	static int[] nums;
	static int result;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[201][201];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		nums = new int[3];
		result = 0;
		combi(0,1);

		System.out.println(result);
	}
	private static void combi(int depth, int start) {

		if(depth == 3) {
			int a = nums[0];
			int b = nums[1];
			int c = nums[2];
			if(map[a][b] != 1 && map[a][c] != 1 && map[b][c] != 1) {
				result++;
			}
			
			return;
		}
		
		for (int i = start; i <= N; i++) {
			nums[depth] = i;
			combi(depth+1,i+1);
		}
	}

}
