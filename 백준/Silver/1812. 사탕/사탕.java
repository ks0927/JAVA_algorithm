import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int V = Integer.parseInt(br.readLine());
			arr[i] = V;
			sum+=V;
		}
		
		sum/=2;
		
		int[] result = new int[N];
		
		for (int i = 0; i < N; i++) {
			int cnt = N/2;
			int temp = sum;
			int index = (i+1)%N;
			
			temp-= arr[index];
			cnt--;
			
			while(cnt > 0) {
				index += 2;
				index %= N;
				
				temp -= arr[index];
				cnt--;
			}
			
			result[i] = temp;
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.print(sb);
	}

}
