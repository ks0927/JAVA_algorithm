import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static Long module = 1_000_000_007L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Long top = top();
//		System.out.println("top: "+ top);
		Long bottom = bottom();
//		System.out.println("bottom: "+ bottom);
		
		int result = (int) (((top % module) * (bottom % module)) % module);
		System.out.println(result);
	}

	private static Long bottom() {
		Long fact = fact();
		Long sum = power(fact, module - 2);
		return sum;
	}

	private static Long fact() {
		Long sum = 1L;
		for (int i = 1; i <= K; i++) {
			sum = (sum * (i % module)) % module;
		}
		return sum;
	}

//  재귀로 만드니까 스택오버플로우
//	private static Long power(Long base, Long exp) {
//		if (exp == 0) {
//			return 1L;
//		}
//		if (exp % 2 == 0) {
//			return power(base, exp / 2) % module * power(base, exp / 2) % module;
//		} else {
//			return power(base, 1L) % module * power(base, (exp - 1) / 2) % module * power(base, (exp - 1) / 2) % module;
//		}
//	}
	
	private static Long power(Long base, Long exp) {
	    Long result = 1L;
	    while (exp > 0) {
	        if (exp % 2 == 1) {  // 지수가 홀수인 경우
	            result = (result * base) % module;
	        }
	        base = (base * base) % module;
	        exp /= 2;
	    }
	    return result;
	}

	private static Long top() {
		Long sum = 1L;
		for (int i = N - K + 1; i <= N; i++) {
			sum = (sum * (i % module)) % module;
		}
		return sum;
	}

}
