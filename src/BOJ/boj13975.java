package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13975 {

    static int T;
    static Long[] resultList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        resultList = new Long[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            //우선순위큐로 오름차순으로 배치한다.
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {

                Long chapter = Long.parseLong(st.nextToken());
                priorityQueue.add(chapter);
            }

            Long result = 0L;
            // 우선순위큐를 2번 poll하면 가장작은 2개의 챕터가 나오고 해당 챕터를 더한다.
            while(priorityQueue.size() != 1){
                Long poll1 = priorityQueue.poll();
                Long poll2 = priorityQueue.poll();

                Long combineChapter = poll1 + poll2;
                result+= combineChapter;
                priorityQueue.add(combineChapter);
            }
            resultList[i] = result;
        }

        for (Long i : resultList) {
            System.out.println(i);
        }

    }
}
