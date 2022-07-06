package Array;

import java.util.Scanner;

public class mountainTop {
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
    }
}
