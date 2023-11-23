import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        //세로
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            //가로
            for (int j = 0; j < M; j++) {
                board[i][j] =s.charAt(j);
            }
        }
        

        int paintCount = Integer.MAX_VALUE;
        // 세로 시작인덱스
        for (int i = 0; i <= N - 8; i++) {
            //가로 시작인덱스
            for (int j = 0; j <= M - 8; j++) {
                paintCount = Math.min(calculate(i,j,board),paintCount);
            }
        }

        System.out.println(paintCount);
    }

    public static int calculate(int i, int j, char[][] board) {

        int count =0;
        int Wcount = 0;
        int Bcount = 0;

        char preColor = 'B';

        //왼쪽모서리가 W로 시작할때
        //세로 끝 인덱스
        for (int k = i; k < i+8; k++) {
            // 가로 끝 인덱스
            for (int l = j; l < j+8; l++) {
                if(board[k][l] == preColor){
                    Wcount++;
                    preColor = reverse(preColor);
                    continue;
                }
                preColor =reverse(preColor);
            }
            //8개씩 이니까 한 라인당 한번씩 뒤집어줘야함
            //체스판의 크기가 안정해져있다면 골치아프겠군.
            preColor = reverse(preColor);
        }


        preColor = 'W';
        //왼쪽모서리가 B로 시작할때
        //세로 끝 인덱스
        for (int k = i; k < i+8; k++) {
            // 가로 끝 인덱스
            for (int l = j; l < j + 8; l++) {
                if (board[k][l] == preColor) {
                    Bcount++;
                    preColor = reverse(preColor);
                    continue;
                }
                preColor = reverse(preColor);
            }
            //8개씩 이니까 한 라인당 한번씩 뒤집어줘야함
            //체스판의 크기가 안정해져있다면 골치아프겠군.
            preColor = reverse(preColor);
        }

        //어? 뭐임 실수로 Math.min 이아니라 max로 하면서 알게된건데
        //흰색 시작하고 검은색 시작은 서로 반대네? 그니까 1이면 63, 2면 62 처럼
        count = Math.min(Bcount,Wcount);

        return count;
    }

    public static char reverse(char preColor) {
        if(preColor == 'B'){
            return 'W';
        }else {
            return 'B';
        }
    }    
    
}