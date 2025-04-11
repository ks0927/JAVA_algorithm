import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if(checkGroup(str)) result++;
		}
		
		System.out.println(result);
	}

	private static boolean checkGroup(String str) {
		HashMap<Character,Integer> map = new HashMap<>();

		map.put(str.charAt(0), 0);
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				continue;
			}else {
				if(map.containsKey(str.charAt(i))) return false;
				
				map.put(str.charAt(i), i);
			}
		}
		
		return true;
	}

}
