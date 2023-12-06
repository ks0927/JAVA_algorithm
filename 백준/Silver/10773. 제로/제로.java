import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int money = Integer.parseInt(br.readLine());

            if (money == 0) {
                stack.pop();
                continue;
            }

            stack.push(money);
        }
        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
