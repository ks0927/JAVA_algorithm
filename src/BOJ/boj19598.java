package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj19598 {
    static class Conferences implements Comparable<Conferences> {
        int start;
        int end;

        public Conferences(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conferences o) {
            //오름차순
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }


        @Override
        public String toString() {
            return "Conferences{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
        static int N;
        static List<Conferences> conferences;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        conferences = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            conferences.add(new Conferences(start,end));
        }

        // 시작 시간을 기준으로 오름차순 정렬하되,
        // 시작 시간이 같다면, 종료 시간을 기준으로 오름차순 정렬한다.
        // compareTo로 정의해뒀다.
        Collections.sort(conferences);

/*        for (Conferences conference : conferences) {
            System.out.println("conference = " + conference);
        }*/

        //우선순위 큐에는 종료시간만 들어가며 디폴트값은 오름차순으로 정렬된다.
        PriorityQueue<Integer> priorityQueueEndTime = new PriorityQueue<>();
        //초기값 넣어주기
        priorityQueueEndTime.add(conferences.get(0).end);

        for (int i = 1; i < N; i++) {
            // 우선순위 큐에서 가장 작은 종료 시간과
            // 현재 뽑은 conference 의 시작 시간을 비교한다.
            // 만약 시작시간이 가장 작은 종료시간보다 크면 그 시간대 를 이어서 한다고 생각하면된다.
            // 그러니 이어졌다고 생각하고 가장 작은 종료시간은 poll로 뺀다.
            if (priorityQueueEndTime.peek() <= conferences.get(i).start) {
                priorityQueueEndTime.poll();
            }
            // 가장 작은 종료시간보다 시작시간이 크든 작든 현재 end값은 넣어줘야한다.
            priorityQueueEndTime.add(conferences.get(i).end);
        }

        // 현재 우선순위 큐에 남아있는 요소의 개수가 필요한 최소한의 회의실 개수이다.
        System.out.println(priorityQueueEndTime.size());
    }
}
