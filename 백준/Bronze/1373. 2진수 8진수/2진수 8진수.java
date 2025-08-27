import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String value = br.readLine();

		System.out.println(new BigInteger(value,2).toString(8));
	}

}
