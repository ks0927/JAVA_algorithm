import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] map = new boolean[20_000_001];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            if(parseInt < 0) {
                parseInt *= -1;
                parseInt += 10_000_000;
            }

            map[parseInt] = true;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            if(parseInt < 0) {
                parseInt *= -1;
                parseInt += 10_000_000;
            }
            if(map[parseInt]){
                sb.append(1).append(" ");
            }else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
