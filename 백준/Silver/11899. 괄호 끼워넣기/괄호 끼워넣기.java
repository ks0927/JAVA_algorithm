import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			char v = str.charAt(i);
			
			if(stack.isEmpty()) {
				stack.push(v);
				continue;
			}
			
			char peek = stack.peek();
			if(peek == '(') {
				if(v == ')') {
					stack.pop();
					continue;
				}
			}
			
			stack.push(v);
		}
		
		System.out.println(stack.size());
	}

}
