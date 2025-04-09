import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[500001];
		int limit = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
			limit = Math.max(limit, s);
		}

		int[] dp = new int[limit + 1];
		int[] idx = new int[limit + 1];
		
		int size = 1;
		for (int i = 1; i <= limit ; i++) {
			if(map[i] == 0) {
				idx[i] = -1;
				continue;
			}
			
			int temp = Arrays.binarySearch(dp, 1,size,map[i]);
			
			int pos = Math.abs(temp) - 1;
			idx[i] = pos;
			dp[pos] = map[i];
			if(pos == size) ++size;
			
		}
		
		System.out.println(N - size + 1);
		
		int id = size - 1;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = limit; i >= 1; i--) {
			
			if(idx[i] == -1) continue;
			
			if(idx[i] == id) {
				id--;
			}else {
				result.add(i);
			}
		}
		
		Collections.sort(result);
		
		for (int v : result) {
			sb.append(v).append("\n");
		}
		
		System.out.println(sb);
	}

}
