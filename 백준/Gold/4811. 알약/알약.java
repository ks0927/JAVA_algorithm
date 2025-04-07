import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		long[][] map = new long[31][31]; //long[W][H] 와 같다. 
		
		for (int i = 1; i <= 30; i++) {
			map[i][0] = 1;
		}
		
		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			sb.append(map[N][N]).append("\n");
		}
		
		System.out.print(sb);
		
	}

}
