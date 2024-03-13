import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);
            visited[A] = true;
            command[A] = "";

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {

                    Integer poll = queue.poll();

                    if (poll.equals(B)) {
                        sb.append(command[B]).append("\n");
                        queue.clear();
                        break;
                    }
                    int D = (poll * 2) % 10000;
                    int S = poll - 1;
                    if (poll == 0) {
                        S = 9999;
                    }

                    int L = (poll % 1000) * 10 + (poll / 1000);
                    int R = (poll % 10) * 1000 + (poll / 10);

                    if (!visited[D]) {
                        queue.add(D);
                        visited[D] = true;
                        command[D] = command[poll] + "D";
                    }

                    if (!visited[S]) {
                        queue.add(S);
                        visited[S] = true;
                        command[S] = command[poll] + "S";
                    }

                    if (!visited[L]) {
                        queue.add(L);
                        visited[L] = true;
                        command[L] = command[poll] + "L";
                    }

                    if (!visited[R]) {
                        queue.add(R);
                        visited[R] = true;
                        command[R] = command[poll] + "R";
                    }
                }
            }

        }
        System.out.println(sb);


    }


}

