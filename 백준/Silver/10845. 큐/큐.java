import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String execute = st.nextToken();
            if(execute.equals("push")){
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            }

            if (execute.equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer poll = queue.poll();
                sb.append(poll).append("\n");
            }

            if (execute.equals("size")){
                int size = queue.size();
                sb.append(size).append("\n");
            }

            if (execute.equals("empty")){
                if(queue.isEmpty()){
                    sb.append(1).append("\n");
                    continue;
                }
                sb.append(0).append("\n");
            }

            if (execute.equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer peek = queue.peek();
                sb.append(peek).append("\n");
            }

            if (execute.equals("back")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(last).append("\n");
            }
        }
        System.out.println(sb);
    }
}
