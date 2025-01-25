import java.io.*;
import java.util.*;

public class Main {

	static int[] p;
	static int[] select;
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
		
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}

		combi(0,0);
		System.out.println(sb);

	}

	public static void combi(int depth,int start) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = start; i < N; i++) {
//			if(visited[i]) continue;
			
			select[depth] = p[i];
			combi(depth + 1,i + 1);
			select[depth] = 0;
		}
	}
}
