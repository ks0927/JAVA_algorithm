import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                queue.add(parseInt);
            }

            int flag = 1;
            while (true) {
                Integer poll = queue.poll();

                if (poll - flag > 0) {
                    queue.add(poll - flag);
                } else {
                    queue.add(0);
                    break;
                }
                flag++;

                if (flag > 5) {
                    flag = 1;
                }
            }
            sb.append("#").append(i + 1).append(" ");
            for (int j = 0; j < 8; j++) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }


}
