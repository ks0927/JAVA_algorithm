package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //한줄을 가져오고 해당 줄을 - 기준으로 String을 나눈다. true를 해서 - 도 넣는다.
        StringTokenizer st1 = new StringTokenizer(bf.readLine(), "-", true);

        //문자열들을 담을 큐
        Queue<String> queue = new LinkedList<>();

        //- 기준으로 나눠진 string을 돌면서 다시 + 기준으로 나눠서 숫자와 문자 모두 담는다.
        while (st1.hasMoreTokens()){
//            System.out.println("st = " + st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+", true);
            while (st2.hasMoreTokens()){
                queue.add(st2.nextToken());
            }
        }

        int result = 0;
        // 마이너스 연산자를 관리하는 flag
        boolean minusFlag = false;
        for (String value : queue) {
//            System.out.println("s = " + value);

            // 만약 - 가 있다면 true로 바꾼다.
            if(value.equals("-")){
                minusFlag = true;
            }

            //만약 숫자라면
            if(!(value.equals("-") || value.equals("+"))){
                int number = Integer.parseInt(value);

                // 마이너스가 앞에서 한번이라도 나왔다면 괄호로 감싸서 다 더한것이 최소값이 된다.
                // 즉 다 빼면됨.
                if(minusFlag){
                    result -= number;
                    continue;
                }

                // 마이너스가 나온적이 없으면 그냥 더한다.
                result += number;
            }
        }
        System.out.println(result);

    }
}
