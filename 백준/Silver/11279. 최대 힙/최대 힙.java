import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }

                Integer poll = queue.poll();
                sb.append(poll).append("\n");
            }

            queue.add(N);
        }

        System.out.println(sb);

    }


}

