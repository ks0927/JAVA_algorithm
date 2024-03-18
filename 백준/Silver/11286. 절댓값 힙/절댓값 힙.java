import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // compare의 값이 양수 라는것은 두 원소의 위치를 교환한다는 것이다.
        // 즉 큰값이 뒤로 가지고있는것. 즉 절대값이 오름차순으로 정렬된다는것.
        // 만약 절대값이 같으면 다시 오름차순으로 정렬하기.
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2) ) {
                    return 1;
                }
                else if(Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                }
                else {
                    if(o1 > o2) {
                        return 1;
                    }
                    else if(o1 < o2) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }

                Integer poll = queue.poll();
                sb.append(poll).append("\n");
                continue;
            }

            queue.add(N);
        }

        System.out.println(sb);

    }


}

