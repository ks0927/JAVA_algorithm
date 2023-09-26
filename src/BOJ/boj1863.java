package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1863 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // y가 0이면 스택 초기화
            if(y == 0){
                stack.clear();
                continue;
            }

            //스택이 비었을때 넣어준다.
            if(stack.isEmpty()){
                stack.push(y);
                result++;
                continue;
            }

            //현 스택 peek값보다 y가 작으면 pop한다.
            //
            if(y < stack.peek()){

/*                // 스택에서 현재 y보다 큰 값들은 다뺀다.
                for (Integer integer : stack) {
                    if(y < integer)
                        stack.pop();
                }*/

                // 스택에서 현재 y보다 큰 값들은 다뺀다.
                Iterator<Integer> iterator = stack.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    if (y < integer) {
                        iterator.remove(); // for문대신 Iterator로 순회
                    }
                }

                // 혹시 다빠져서 스택이 비었을때 넣어준다.
                if(stack.isEmpty()){
                    stack.push(y);
                    result++;
                    continue;
                }

                // 스택을 뒤져서 y하고 같은값이 없으면 넣어준다.
                if(stack.search(y)== -1){
                    stack.push(y);
                    result++;
                }
                continue;
            }

            //현 스택 peek값보다 y가 같으면 pass한다.
            if(y == stack.peek()){
                continue;
            }

            //현 스택 peek값보다 y가 크면 y값을 push한다.
            if(y > stack.peek()){
                stack.push(y);
                result++;
                continue;
            }
        }

        System.out.println(result);
    }

}
