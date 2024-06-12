import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Long money = 0L;
		boolean check = true;
		
		for(int i = 0 ; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			
			if(type.equals("in")) {
				money += value;
			}
			
			if(type.equals("out")) {
				money -= value;
				
				if(money < 0) {
					check = false;
				}
			}
		}
		
		if(check) {
			System.out.print("success");
		}else{
			System.out.print("fail");
		}
		
	}
}