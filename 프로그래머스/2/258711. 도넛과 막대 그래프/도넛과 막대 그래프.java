import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        // 참고 https://given-dev.tistory.com/104
        //{생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수}
        int[] answer = new int[4];

        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for (int[] edge : edges) {
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }

        for (Integer OUT : out.keySet()) {
            Integer value = out.get(OUT);

            if (value >= 2) {
                if (in.containsKey(OUT)) {
                    answer[3] += 1;
                } else {
                    answer[0] = OUT;
                }
            }
        }

        for (Integer IN : in.keySet()) {
            if (!out.containsKey(IN)) {
                answer[2] += 1;
            }
        }

        answer[1] = out.get(answer[0]) - answer[2] - answer[3];

        return answer;
    }
}