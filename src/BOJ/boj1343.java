package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1343 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String board = st.nextToken();

        //답을 담을 공간
        ArrayList<String> result = new ArrayList<>();

        int count = 0;

        // 입력받은 string을 돈다.
        for (int i = 0; i < board.length(); i++) {

            //만약 .  이 나오면 현재까지 센 count 즉 X의 갯수를 토대로 분기
            if(board.charAt(i) == '.'){
                //만약 X의 값이 2로 나눠진다면 즉 AAAA와 BB가 가능할때
                if(count %2 == 0){

                    // count가 0이 될때까지 무한반복하는데 여기가 그리디 포인트?
                    while(count != 0) {

                        //길이가 4인 AAAA를 먼저 넣는다. 최적선택
                        if (count >= 4) {
                            result.add("AAAA");
                            count -= 4;
                        }

                        //그다음 남은 길이가 4미만일때는 BB를 넣는다.
                        if (count >= 2 && count < 4) {
                            result.add("BB");
                            count -= 2;
                        }
                    }
                    result.add(".");

                }
                //  X의 값이 2로 안 나눠진다면 즉 AAAA와 BB가 불가능
                else {
                    System.out.println("-1"); //-1반환
                    return;
                }

            }
            // X이면 count++
            else{
                count++;
            }

        }

        //만약 . 이 안나왔는데 count가 0 초과이다? 그렇다는건 XXXX 같은 상황이라는것
        //따로 처리해주자. 방식은 위와 동일하다.
        if(count > 0){

            if(count %2 == 0){

                while(count != 0) {

                    if (count >= 4) {
                        result.add("AAAA");
                        count -= 4;
                    }

                    if (count >= 2 && count < 4) {
                        result.add("BB");
                        count -= 2;
                    }
                }
            }
            else {
                System.out.println("-1");
                return;
            }
        }

        //결과 반환
        for (String s : result) {
            System.out.print(s);
        }




    }
}
