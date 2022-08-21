package DfsBfsEx;

import java.util.Scanner;

public class islandCount {
    static int[][] direction ={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}}; // 위 아래 왼쪽 오른쪽 왼쪽위 오른쪽위 왼쪽아래 오른쪽아래
    static int[][] map;
    static int[][] count_map;
    static int n;
    static int answer;

    public void DFS(int x, int y){
        for(int i=0; i<8; i++){ //8방향 탐색
            int next_y = y + direction[i][0];
            int next_x = x + direction[i][1];
            if(next_x>=0 && next_x<n && next_y>=0 && next_y<n && map[next_y][next_x]==1 &&count_map[next_y][next_x]==0){//8방향탐색하면서 map이 1이면서 아직안갔을때(count가 0일때)
                count_map[next_y][next_x]=answer;
                DFS(next_x, next_y);
            }
        }

    }

    public static void main(String[] args) {
        islandCount I = new islandCount();
        Scanner kb =new Scanner(System.in);

        n = kb.nextInt();
        map = new int[n][n];
        count_map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]= kb.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1 && count_map[i][j]==0){
                    answer++;
                    count_map[i][j]=answer; //처음 만난값 집어넣기 , 이거안하니까 한칸짜리 섬은 표기가 안되네 answer에 카운트는 된다만...
                    I.DFS(j,i);
                }
            }
        }
/*        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(count_map[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.print(answer);

    }
}
