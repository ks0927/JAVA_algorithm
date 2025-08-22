import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int[] isbn = new int[13];
		int index = -1;
		
		for (int i = 0; i < isbn.length; i++) {
			int v =input.charAt(i) - '0';
			isbn[i] = v;
			
			if(input.charAt(i) == '*')
				index = i;
		}
		
		
		for (int i = 0; i < 10; i++) {
			isbn[index] = i;
			
			int sum = 0;
			for (int j = 0; j < isbn.length; j++) {
				if(j%2 == 0) {
					sum += isbn[j];
				}else {
					sum += (3 * isbn[j]);
				}
			}
			if(sum%10 == 0) {
				System.out.println(i);
				return;
			}
		}
	}

}
