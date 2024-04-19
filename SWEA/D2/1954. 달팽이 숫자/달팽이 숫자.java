/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    
    
    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            int count = 0;
            int x = 0;
            int y = 0;
            int value = 1;
            int flag = 0;
            while (count != N * N) {
                map[y][x] = value++;
                count++;
                int nextX = x + directionX[flag];
                int nextY = y + directionY[flag];

                if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N || map[nextY][nextX] != 0) {
                    flag = changeFlag(flag);
                    x += directionX[flag];
                    y += directionY[flag];
                    continue;
                }

                x = nextX;
                y = nextY;
            }

            sb.append("#").append(i + 1).append("\n");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(map[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
	}
    
        static int changeFlag(int flag) {
        if (flag == 0)
            return 1;
        if (flag == 1)
            return 2;
        if (flag == 2)
            return 3;
        if (flag == 3)
            return 0;

        return -1;
    }
}