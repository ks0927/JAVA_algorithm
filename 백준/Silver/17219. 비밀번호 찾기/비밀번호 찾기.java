import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String email = st.nextToken();
            String password = st.nextToken();

            map.put(email, password);
        }

        for (int i = 0; i < M; i++) {
            String email = br.readLine();
            String password = map.get(email);
            sb.append(password).append("\n");
        }

        System.out.println(sb);
    }


}
