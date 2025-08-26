import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] d = new int[3];

		d[0] = Integer.parseInt(st.nextToken());
		d[1] = Integer.parseInt(st.nextToken());
		d[2] = Integer.parseInt(st.nextToken());

		double s = (d[0] + d[1] + d[2]) / 2.0;

		double r1 = s - d[2];
		double r2 = s - d[1];
		double r3 = s - d[0];

		if(r1 <= 0 || r2 <= 0 || r3 <= 0) {
			System.out.println(-1);
		}else {
			System.out.println(1);
			System.out.printf("%.1f %.1f %.1f",r1,r2,r3);
		}
		
	}

}
