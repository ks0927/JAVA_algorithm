package Array;

import java.util.Scanner;

public class raking {
    public int[] solution(int[] arr){
        int[] answer = new int[arr.length];
        int cnt = 1;
        int tmp;
        //점수들을 돌면서 나보다 높은 점수가 있으면 등수를 + 해서 낮추는 방식
        for(int i=0; i< arr.length ; i++){
            tmp =arr[i];
            for(int j = 0; j< arr.length; j++){
                if(tmp < arr[j])
                    cnt++;
            }
            answer[i] = cnt;
            cnt= 1;
        }
        return answer;
    }

    public static void main(String[] args){
        raking R = new raking();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i< arr.length; i++)
            arr[i] = kb.nextInt();

        for(int x : R.solution(arr))
            System.out.print(x+" ");

    }
}
