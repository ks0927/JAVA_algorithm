import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int min = 0;

        for (int i = 1; i <= 10000; i++) {
            if (N % i == 0 && M % i == 0){
                max = Math.max(i,max);
            }
        }

        for (int i = 1; i <= 100000000; i++) {
            if (i % N == 0 && i % M == 0){
                min = i;
                break;
            }
        }
        
        System.out.println(max);
        System.out.println(min);
    }
}