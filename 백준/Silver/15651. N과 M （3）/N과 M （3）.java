import java.io.*;
import java.util.*;

public class Main {

	static int[] p;
	static int[] select;
//	static boolean[] visited;
	static int M;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		p = new int[N];
		select = new int[M];
//		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}

		perm(0);
		System.out.println(sb);

	}

	public static void perm(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
//			if(visited[i]) continue;
			
//			visited[i] = true;
			select[depth] = p[i];
			perm(depth + 1);
//			visited[i] = false;
			select[depth] = 0;
		}
	}
}
