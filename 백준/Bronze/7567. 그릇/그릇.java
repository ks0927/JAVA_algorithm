import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int result = cup(str);

		System.out.println(result);
	}

	public static int cup(String str) {

		char cur = str.charAt(0);

		int height = 10;

		for (int i = 1; i < str.length(); i++) {

			if (str.charAt(i) == cur) {
				height += 5;
			} else {
				cur = str.charAt(i);
				height += 10;
			}

		}
		return height;
	}

}