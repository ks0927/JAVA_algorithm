import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] times;
	static int[] degree;
	static int[] answers;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		degree = new int[N+1];
		times = new int[N+1];
		answers = new int[N+1];
		adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;
			
			while(st.hasMoreTokens()) {
				int cur  = Integer.parseInt(st.nextToken());
				if(cur == -1)
					break;
				
				adj[cur].add(i);
				degree[i]++;
			}
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				queue.add(i);
				answers[i] = times[i];
			}
		}
	

		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			int sum = answers[poll];
			
			for(int next : adj[poll]) {
				degree[next] -= 1;
				
				answers[next] = Math.max(answers[next],sum);
				if(degree[next] == 0) {
					queue.add(next);
					answers[next] += times[next];
				}
				
			}
		}
		
		StringBuilder sb= new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answers[i]).append("\n");
		}
		System.out.print(sb);
	}

}
