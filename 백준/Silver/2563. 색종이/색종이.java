import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[101][101];

		int size = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int leftR = r + 10;
			int leftC = c;

			for (int j = leftR; j > r; j--) {
				for (int j2 = leftC; j2 < leftC + 10; j2++) {
					if(visited[j][j2]) continue;
					
					visited[j][j2] = true;
					size++;
				}
			}
			
		}
		
		System.out.println(size);

	}

}
