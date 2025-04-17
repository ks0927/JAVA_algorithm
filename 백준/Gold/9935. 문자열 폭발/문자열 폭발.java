import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();


        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            stack.addLast(now);

            if(now == target.charAt(target.length() - 1)) {
                int idx = target.length() - 1;

                Iterator<Character> characterIterator = stack.descendingIterator();

                boolean flag = false;
                while(characterIterator.hasNext()) {
                    char n = characterIterator.next();

                    if(n == target.charAt(idx)) {
                        idx--;
                    }else{
                        break;
                    }

                    if(idx == -1) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < target.length(); j++) {
                        stack.pollLast();
                    }
                }
            }

        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
        }else{
            StringBuilder sb= new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }
            System.out.println(sb);
        }

    }


}

