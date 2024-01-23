import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N + 1];
        int[] memo = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            stairs[i] = parseInt;
        }

        if(N == 1){
            System.out.println(stairs[1]);
            return;
        }
        if(N == 2){
            System.out.println(stairs[1]+stairs[2]);
            return;
        }
        
        memo[1] = stairs[1];
        memo[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= N; i++) {
            int value = Math.max(memo[i - 2], memo[i - 3] + stairs[i - 1]) + stairs[i];
            memo[i] = value;
        }

        System.out.println(memo[N]);
    }

}
