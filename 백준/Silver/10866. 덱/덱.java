import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String execute = st.nextToken();
            if (execute.equals("push_back")) {
                last = Integer.parseInt(st.nextToken());
                deque.addLast(last);
            }

            if (execute.equals("push_front")) {
                last = Integer.parseInt(st.nextToken());
                deque.addFirst(last);
            }

            if (execute.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer poll = deque.pollFirst();
                sb.append(poll).append("\n");
            }

            if (execute.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer poll = deque.pollLast();
                sb.append(poll).append("\n");
            }

            if (execute.equals("size")) {
                int size = deque.size();
                sb.append(size).append("\n");
            }

            if (execute.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                    continue;
                }
                sb.append(0).append("\n");
            }

            if (execute.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer peek = deque.peekFirst();
                sb.append(peek).append("\n");
            }

            if (execute.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer peek = deque.peekLast();
                sb.append(peek).append("\n");
            }
        }
        System.out.println(sb);
    }
}
