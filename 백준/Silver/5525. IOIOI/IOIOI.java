import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int result = 0;

        char[] charArray = S.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == 'I') {
                //탐색 범위 밖이면 거기서 끝
                if ((i + 2 * N) >= M) {
                    System.out.println(result);
                    return;
                }

                int count = 0;
                char memo = 'I';
                for (int j = i + 1; j <= i + (2 * N); j++) {
                    if (charArray[j] != memo) {
                        count++;
                        memo = charArray[j];
                    } else {
                        //IOIOI 처럼 서로다른수가 반복되지 않는다면 형식이 다르기에 탐색 종료
                        break;
                    }
                }
                // 한번더 체크
                if (count == 2 * N) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }

}

