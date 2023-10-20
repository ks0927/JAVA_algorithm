package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16500 {

    public static void main(String[] args) throws IOException {
/*      abac
        4
        a
        ba
        bc
        ac*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String S = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] map = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String A = st.nextToken();
            map[i] = A;
        }

        boolean[] isPossibleWord = new boolean[S.length()+1];
        isPossibleWord[0] = true;

        for (int i = 0; i < S.length(); i++) {
            // 현재 잘린단어길이
            int prefixLength = i + 1;

            for (int j = 0; j < N; j++) {
                // 저장된 단어들과 현재 잘린단어의 길이를 비교해서 hit가 되려면 prefixLength >= map[j].length() 여야함
                if(!((prefixLength >= map[j].length())))
                    continue;

                // substring으로 직접 자르고 저장된단어와 같은지 확인해본다.
                if (S.substring(i - (map[j].length() - 1), i + 1).equals(map[j])) {
                    // 같다면 이제 남은 단어는 dp리스트에서 가능한 값인지 확인한뒤 그것도 가능하면 true로
                    if (isPossibleWord[prefixLength - map[j].length()]) {
                        isPossibleWord[prefixLength] = true;
                        break;
                    }
                }
            }
        }

        int result;
        if (isPossibleWord[S.length()]){
            result = 1;
        } else {
            result = 0;
        }

        System.out.println(result);

    }
}
