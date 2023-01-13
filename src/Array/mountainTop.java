package Array;

import java.util.Scanner;

public class mountainTop {
    //indexOutOfRange 대비용으로 plate라는 0으로 둘러쌓인 배열을 만들어서 해결한경우
    public int solution(int n,int[][] arr){
        int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}};
        int[][] plate = new int[n+2][n+2];

        int answer= 0;
        for(int i=1; i<n+1 ; i++){
            for(int j =1; j<n+1; j++)
                plate[i][j]= arr[i-1][j-1];
        }
        for(int i=1; i<n+1 ; i++){
            for(int j =1; j<n+1; j++){
                boolean check =true;
                for(int k=0; k<4 ; k++){
                    int tmp_x = i + direction[k][1];
                    int tmp_y = j + direction[k][0];
                    if(plate[tmp_y][tmp_x]>=plate[j][i]){
                        check=false;
                        break;
                    }
                }
                if(check)
                    answer++;
            }
        }

        return answer;
    }
    //if문을 통해 index가 0이상일때를 한정지어서 indexOutOfRange를 회피한경우
    public int solution2(int n, int[][] arr){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int answer =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if(nx>= 0 && nx <n && ny>= 0 && ny <n && arr[ny][nx]>= arr[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args){
        mountainTop M = new mountainTop();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n ; i++){
            for(int j =0; j<n; j++)
                arr[i][j]= kb.nextInt();
        }

        System.out.println(M.solution(n,arr));
        System.out.println(M.solution2(n,arr));
    }
}
