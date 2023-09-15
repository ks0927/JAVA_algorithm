package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2828 {


    static int[] apple;
    static int N;
    static int M;
    static int J;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        J = Integer.parseInt(st.nextToken());

        apple = new int[J];

        //바구니의 폭 N을 생각해서 왼쪽끝과 오른쪽끝의 인덱스를 나눠서 생각하자
        int basketLeft = 1;
        int basketRight = 1 + (N -1);
        result = 0;

        for (int i = 0; i < J; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            apple[i] = a;
        }

        for (int appleIndex : apple) {

            //만약 받아야할 사과의 인덱스가 바구니의 오른쪽 끝보다 크다면 오른쪽에 있다는것
            if(appleIndex > basketRight){
                //그만큼 이동해주자
                int distance = appleIndex - basketRight;
                result+=distance;
                basketLeft+=distance;
                basketRight+=distance;
            }
            //만약 받아야할 사과의 인덱스가 바구니의 왼쪽 끝보다 작면 왼쪽에 있다는것
            if(appleIndex < basketLeft){
                //그만큼 이동해주자
                int distance = basketLeft - appleIndex;
                result+=distance;
                basketLeft-=distance;
                basketRight-=distance;
            }
            //그러면 위의 if문 조건에 걸리지 않았을때는 바구니 내부에 사과가 떨어진다는 이야기다.
        }

        System.out.println(result);

    }
}
