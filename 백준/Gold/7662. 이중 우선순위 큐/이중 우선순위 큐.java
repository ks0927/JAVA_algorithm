import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            //기본 오름차순
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                // op 가 D 일때
                else {
                    //비어있다면 pass
                    if (map.isEmpty()) {
                        continue;
                    }

                    int pollNumber;
                    // 1이면 가장 큰값 가져오기
                    if (num == 1) {
                        pollNumber = map.lastKey();
                    }
                    // num이 -1일때 가장 작은 값 가져오기
                    else {
                        pollNumber = map.firstKey();
                    }

                    // 뽑힌 값의 value 값을 -1 하고 -1 하기전의 값이 만약 1 이라면 제거
                    if (map.put(pollNumber, map.get(pollNumber) - 1) == 1) {
                        map.remove(pollNumber);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);

    }


}

