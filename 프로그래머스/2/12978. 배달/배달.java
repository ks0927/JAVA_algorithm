import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {

        int[][] map = new int[N+1][N+1];
        
        int INF = Integer.MAX_VALUE / 4;
        for(int i=0; i <= N ; i++) {
            for(int j=0; j <= N; j++) {
                if(i==j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }
        
        for(int i=0; i < road.length;i++) {
            map[road[i][0]][road[i][1]] = Math.min(map[road[i][0]][road[i][1]],road[i][2]);
            map[road[i][1]][road[i][0]] = Math.min(map[road[i][1]][road[i][0]],road[i][2]);
        }
        
        
        for(int k=1; k <=N ; k++) {
            for(int i=1; i <= N; i++) {
                for(int j=1; j <= N; j++) {
                    
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1 ; i <= N; i++) {
            if(map[1][i] <= K) answer++;
        }
        return answer;
    }
}