package Array;

import java.util.Scanner;

public class mentoring {
    public int indexOf(int[] arr, int num){ //인덱스 위치 알려주는 함수
        for(int i =0; i< arr.length; i++){
            if(arr[i]==num)
                return i;
        }
        return -1;
    }

    public boolean ableMento(int mento, int menti,int test,int[][] arr){
        for(int i=0; i<test; i++){
            if(indexOf(arr[i],mento+1)>indexOf(arr[i],menti+1)) //멘토가 멘티보다 뒷 등수면 안된다.
                return false;
        }
        return true;
    }


    public int solution(int s,int t, int[][] arr){
        int[][] pair= new int[s][s];
        int answer =0;
        for(int i=0; i<s; i++){   //i=0 ->1번사람임     , i사람과
            for(int j= 0; j<s; j++){ //j=0 ->1번사람임  , j사람을 비교하기
                if(i==j)
                    continue;
                if(ableMento(i,j,t,arr))  //i가 j의 멘토가 될수있습니까?
                    pair[i][j]++;  //가능할때 1 체크
            }
        }
        for(int i=0; i<s ; i++){
            for(int j =0; j<s; j++) {
                if (pair[i][j] == 1) //가능한 페어 세기
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        mentoring M = new mentoring();
        Scanner kb= new Scanner(System.in);

        int student = kb.nextInt();
        int test = kb.nextInt();
        int[][] arr = new int[test][student];
        for(int i=0; i<test ; i++){
            for(int j =0; j<student; j++)
                arr[i][j]= kb.nextInt();
        }
        System.out.println(M.solution(student,test,arr));

    }
}
