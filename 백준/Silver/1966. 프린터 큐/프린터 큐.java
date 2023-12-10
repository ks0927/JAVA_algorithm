import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Doc> queue = new LinkedList<>();
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                array.add(parseInt);
                queue.add(new Doc(parseInt, j));
            }
            Doc target = new Doc(array.get(M), M);

            int answer = 0;
            while (!queue.isEmpty()) {
                if (hasBigger(queue.peek().value, queue)) {
                    Doc poll = queue.poll();
                    queue.add(poll);
                }
                else {
                    Doc poll = queue.poll();
                    answer++;
                    if (poll.value == target.value && poll.index == target.index) {
                        break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Doc {
        int value;
        int index;

        public Doc(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static boolean hasBigger(Integer target, Queue<Doc> queue) {
        return queue.stream().
                anyMatch(integer -> integer.value > target);
    }

}
