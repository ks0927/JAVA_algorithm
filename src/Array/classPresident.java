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
                    if(arr[i][k]==arr[j][k]){ //학생1과 학생2이 k+1 학년일때 같은반인가?
                        knowStudent[i]++;      //같다면 학생1 에 친구 +1명
                        break;                //친구 찾았으니 다음 친구로 넘어가
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            if(knowStudent[i]==Arrays.stream(knowStudent).max().getAsInt()) { //stream으로 intstream으로 변환한뒤 max로 intstream의 제일큰값찾고 그값은 OptionalInt여서 getasInt로 int로 타입변경
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
