import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		HashSet<Character> vaild = new HashSet<Character>();
		vaild.add('a');
		vaild.add('e');
		vaild.add('i');
		vaild.add('o');
		vaild.add('u');

		StringBuilder sb = new StringBuilder();
		
		String value = "";
		boolean flag = false;
		for (int i = 0; i < str1.length(); i++) {

			if (!flag && vaild.contains(str1.charAt(i))) {
				flag = true;
			}

			if (flag) {
				if (!vaild.contains(str1.charAt(i))) {
					sb.append(str1.substring(0, i));
					value +=(str1.substring(0, i));
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("no such exercise");
			return;
		}
		if (flag && value.isEmpty()) {
			System.out.println("no such exercise");
			return;
		}
		
		
		flag = false;
		value = "";
		for (int i = 0; i < str2.length(); i++) {

			if (!flag && vaild.contains(str2.charAt(i))) {
				flag = true;
			}

			if (flag) {
				if (!vaild.contains(str2.charAt(i))) {
					sb.append(str2.substring(0, i));
					value +=(str1.substring(0, i));
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("no such exercise");
			return;
		}
		if (flag && value.isEmpty()) {
			System.out.println("no such exercise");
			return;
		}
		
		System.out.println(sb);
	}

}
