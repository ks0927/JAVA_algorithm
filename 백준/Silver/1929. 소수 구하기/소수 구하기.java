import java.util.*;
import java.io.*;

public class Main {
    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        primes = new boolean[end+1];
        setUpPrimes(end+1);
        for (int i = start; i <= end; i++) {
            if (!primes[i]) {
                System.out.println(i);
            }
        }
    }

    public static void setUpPrimes(int max) {

        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if(primes[i]){
                continue;
            }

            for (int j = i*i; j < max; j+=i) {
                primes[j] = true;
            }
        }
    }
}