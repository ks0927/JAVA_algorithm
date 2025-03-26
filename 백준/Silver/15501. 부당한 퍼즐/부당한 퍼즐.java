import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] moved = new int[N];
		int[][] points = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			moved[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int pre = (i + N - 1) % N;
			int next = (i + 1) % N;
			
			int now = arr[i];
			points[now][0] = arr[pre];
			points[now][1] = arr[next];
//			System.out.println("now ="+now+" pre = "+arr[pre]+"next ="+arr[next]);
		}
		
		for (int i = 0; i < N; i++) {
			int cur = moved[i];
			int pre = (i + N - 1) % N;
			int next = (i + 1) % N;
			
//			System.out.println("cur ="+cur+" pre = "+moved[pre]+"next ="+moved[next]);
			
			int curPre = moved[pre];
			int curNext = moved[next];
			
			if(points[cur][0] == curPre) {
				if(points[cur][1] == curNext) {
					continue;
				}
			}
			
			if(points[cur][0] == curNext) {
				if(points[cur][1] == curPre) {
					continue;
				}
			}
			
			System.out.println("bad puzzle");
			return;

		}
		
		System.out.println("good puzzle");
	}

}
