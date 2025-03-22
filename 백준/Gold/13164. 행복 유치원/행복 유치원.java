import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] heights = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dis = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			dis[i] = heights[i+1] - heights[i];
		}
//		System.out.println(Arrays.toString(dis));
		Arrays.sort(dis);
//		System.out.println(Arrays.toString(dis));
		int size = N - 1 - (K -1);
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum+=dis[i];
		}
		System.out.println(sum);
	}

}
