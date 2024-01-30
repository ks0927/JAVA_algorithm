import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if(value == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }

                sb.append(queue.poll()).append("\n");
            }

            else {
                queue.add(value);
            }
        }

        System.out.println(sb);
    }
}
