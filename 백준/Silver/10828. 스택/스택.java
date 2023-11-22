import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());


            String ps = st.nextToken();
            if(ps.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            }

            if(ps.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
            }

            if(ps.equals("size")){
                System.out.println(stack.size());
            }

            if(ps.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
            }

            if(ps.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
            }
        }
    }
}