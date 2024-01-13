import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
        boolean minusFlag = false;
        for (String value : queue) {
//            System.out.println("s = " + value);

            if(value.equals("-")){
                minusFlag = true;
            }

            if(!(value.equals("-") || value.equals("+"))){
                int number = Integer.parseInt(value);

                if(minusFlag){
                    result -= number;
                    continue;
                }
                result += number;
            }
        }
        System.out.println(result);

    }
}
