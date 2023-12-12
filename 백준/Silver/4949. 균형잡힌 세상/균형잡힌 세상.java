import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<String> stack = new Stack<>();
            String readLine = br.readLine();

            if (readLine.equals(".")) {
                break;
            }
            sb.append(printResult(stack, readLine)).append("\n");
        }

        System.out.println(sb);
    }

    private static String printResult(Stack<String> stack, String readLine) {
        String[] split = readLine.split("");

        for (String s : split) {
            if (s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else if (s.equals(")") || s.equals("]")) {
                if (stack.isEmpty()) {
                    return "no";
                }

                if (s.equals(")")) {
                    if (!(stack.peek().equals("("))) {
                        return "no";
                    }
                    stack.pop();
                }

                if (s.equals("]")) {
                    if (!(stack.peek().equals("["))) {
                        return "no";
                    }
                    stack.pop();
                }
            }

        }

        if(stack.isEmpty()) {
            return "yes";
        }else {
            return "no";
        }
    }


}
