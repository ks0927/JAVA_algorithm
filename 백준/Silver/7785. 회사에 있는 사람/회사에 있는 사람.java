import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) {
                map.put(name, 1);
            } else {
                map.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        for (String key : keys) {
            sb.append(key).append("\n");
        }

        System.out.print(sb);

    }

}

