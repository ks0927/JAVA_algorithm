import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] insertDegree;
	static ArrayList<Integer>[] map;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		insertDegree = new int[N + 1];
		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			insertDegree[e] += 1;
			map[s].add(e);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(insertDegree[i] == 0) {
				queue.add(i);
				sb.append(i).append(" ");
			}
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				
				for(int end : map[node]) {
					insertDegree[end] -= 1;
					
					if(insertDegree[end] == 0) {
						queue.add(end);
						sb.append(end).append(" ");
					}
				}
			}
		}
		
		System.out.println(sb);
	}

}
