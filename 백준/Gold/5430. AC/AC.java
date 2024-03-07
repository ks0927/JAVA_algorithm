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

