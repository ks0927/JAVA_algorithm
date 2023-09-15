package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13305 {

    static int N;
    static Long result;
    static Long[] distance;
    static Long[] oilPrice;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        distance = new Long[N-1];
        oilPrice = new Long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < distance.length; i++) {
            int a = Integer.parseInt(st.nextToken());
            distance[i] = Long.valueOf(a);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < oilPrice.length; i++) {
            int a = Integer.parseInt(st.nextToken());
            oilPrice[i] = Long.valueOf(a);
        }

        result = 0L;
        int now = 0;
        int next = 0;
        while(now != oilPrice.length-1){

            for (int i = now; i < oilPrice.length; i++) {
                //만약 현재 주유소보다 싼 주유소가있다면
                if(oilPrice[now] > oilPrice[i]){
                    next = i;
                    break;
                }
            }
//            System.out.println("next1 = " + next);
            //나보다 싼 주유소가 더이상 발견되지 않으면 여기서 끝까지 가면된다.
            if(next == now){
                int allDistance = 0;
                for (int i = now; i < distance.length; i++) {
                    allDistance+=distance[i];
                }
                result += oilPrice[now] * allDistance;
                System.out.println(result);
                return;
            }

            //현재부터 싼주유소까지 이동
            int moveDistance = 0;
            for (int i = now; i < next; i++) {
                moveDistance+=distance[i];
            }
            result += oilPrice[now] * moveDistance;
            now = next;
//            System.out.println("result = " + result);

        }

        System.out.println(result);
    }
}
