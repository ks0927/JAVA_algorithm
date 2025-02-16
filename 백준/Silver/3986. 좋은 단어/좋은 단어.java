import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {

                if (stack.empty()) {
                    if (str.charAt(j) == 'A') {
                        stack.add("A");
                    }

                    if (str.charAt(j) == 'B') {
                        stack.add("B");
                    }
                } else {

                    if (stack.peek().equals(String.valueOf(str.charAt(j)))) {
                        stack.pop();
                    } else {
                        stack.add(String.valueOf(str.charAt(j)));
                    }

                }
            }

            if (stack.empty()) result++;
        }

        System.out.println(result);
    }

}