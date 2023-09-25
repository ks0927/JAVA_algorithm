package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj20365 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // R과B를 담을 큐들. 큐는 연속된 색상을 포함해서 한 뭉텅이를 담는다.
        // 예를들면 BBRBRBBR 이면
        // BQueue에 1 1 1
        // RQueue에 1 1 1
        Queue<Integer> BQueue = new LinkedList<>();
        Queue<Integer> RQueue = new LinkedList<>();

        String s = st.nextToken();

        // 초기 flag
        String flag = String.valueOf(s.charAt(0));
        if(flag.equals("R")){
            RQueue.add(1);
        }
        else {
            BQueue.add(1);
        }


        // 반복문을 돌면서 색상 뭉텅이를 확인하는데 flag로 연속된색인지 확인
        for (int i = 0; i < s.length(); i++) {

            String nowColor = String.valueOf(s.charAt(i));
            //같은색이면 넘어가고
            if(nowColor.equals(flag)){
                continue;
            }
            //다른색이면 색상구분해서 큐에 추가
            else{
                flag = nowColor;
                if(nowColor.equals("R")){
                    RQueue.add(1);
                }
                else{
                    BQueue.add(1);
                }
            }

        }

        int result = 0;

        // 큐의 사이즈를 비교해서 뭉텅이가 많은 색상을 한번에 칠해버리고 나머지 색을 칠하는방식.
        if(BQueue.size() > RQueue.size()){
            result += RQueue.size() + 1;
        }
        else {
            result += BQueue.size() + 1;
        }

        System.out.println(result);
    }
}
