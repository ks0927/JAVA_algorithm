import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int sco : scoville) {
            queue.add(sco);
        }

        int answer = 0;
        while (true) {
            if (queue.peek() < K) {
                
                if(queue.size() == 1) {
                    answer = -1;
                    break;
                }
                
                Integer poll1 = queue.poll();
                Integer poll2 = queue.poll();

                queue.add(poll1 + (poll2 * 2));
                answer++;
            }else {
                break;
            }
        }
        
        return answer;
    }
}