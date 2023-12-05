import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");
        int flag = 0;
        while (queue.size() != 1) {
            flag++;
            if(flag == K){
                sb.append(queue.poll()).append(", ");
                flag = 0;
                continue;
            }
            Integer poll = queue.poll();
            queue.add(poll);
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}
