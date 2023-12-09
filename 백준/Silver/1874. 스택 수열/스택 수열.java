import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1,N+1)
                .forEach(num -> queue.add(num));

        Queue<Integer> array = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            array.add(num);
        }

        Stack<Integer> stack = new Stack<>();
        while (!array.isEmpty()) {
            Integer poll = array.poll();
            if(stack.isEmpty() || (stack.peek() < poll)) {
                while (true){
                    stack.add(queue.poll());
                    sb.append("+").append("\n");
                    if(stack.peek().equals(poll)){
                        stack.pop();
                        sb.append("-").append("\n");
                        break;
                    }
                }
                continue;
            }

            if(stack.peek().equals(poll)){
                stack.pop();
                sb.append("-").append("\n");
                continue;
            }

            if(stack.peek() > poll) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

}
