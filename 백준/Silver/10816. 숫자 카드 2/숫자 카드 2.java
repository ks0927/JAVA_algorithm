import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            map.put(parseInt, map.getOrDefault(parseInt, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            if(map.containsKey(parseInt)){
                sb.append(map.get(parseInt)).append(" ");
                continue;
            }
            sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
