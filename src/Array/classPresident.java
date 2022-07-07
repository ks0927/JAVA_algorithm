package Array;

import java.util.Arrays;
import java.util.Scanner;

public class classPresident {

    public int solution(int n, int[][] arr){
        int[] knowStudent = new int[n];
        int answer=0;
        for(int i=0; i<n; i++){   //비교학생1
            for(int j=0; j<n; j++){ //비교학생2
                for(int k=0;k<5; k++){ //학년
                    if(i==j)  //나일땐 제외
                        continue;
                    if(arr[i][k]==arr[j][k]){
                        knowStudent[i]++;
                        break;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            if(knowStudent[i]==Arrays.stream(knowStudent).max().getAsInt()) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){

        classPresident C = new classPresident();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][5];
        for(int i=0; i<n ; i++){
            for(int j =0; j<5; j++)
                arr[i][j]= kb.nextInt();
        }

        System.out.println(C.solution(n,arr));
    }
}
