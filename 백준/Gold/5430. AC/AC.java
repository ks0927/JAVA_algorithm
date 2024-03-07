import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrString = br.readLine();

            if (n == 0) {
                String solutions = solutions(p, deque);
                sb.append(solutions).append("\n");
                continue;
            }
            String substring = arrString.substring(1, arrString.length() - 1);
            String[] split = substring.split(",");
            for (String s : split) {
                deque.add(Integer.parseInt(s));
            }

            String solutions = solutions(p, deque);
            sb.append(solutions).append("\n");

        }

        System.out.println(sb);

    }

    private static String solutions(String p, Deque<Integer> deque) {
        boolean reverseCheck = false;
        for (char P : p.toCharArray()) {
            if (P == 'R') {
                if (!reverseCheck) {
                    reverseCheck = true;
                } else {
                    reverseCheck = false;
                }
            }
            if (P == 'D') {

                if (deque.isEmpty()) {
                    return "error";
                }
                if (reverseCheck) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }

            }
        }
        // StringBuilder 대신 String으로 한뒤 += 연산자로 했더니 시간 초과가 났었다.
        // StringBuilder의 append는 O(1) 이지만 , String의 + 같은 concat은 O(N + K) 이므로 잦은 변경이있다면 StringBuilder를 쓰자
        StringBuilder result = new StringBuilder("[");

        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                result.append(",");
            }
            if (reverseCheck) {
                result.append(deque.pollLast());
            } else {
                result.append(deque.pollFirst());
            }
        }

        result.append("]");
        return result.toString();
    }

}

