package Array;

import java.util.Scanner;

public class eratosthenes {
    public int solution(int n){
        int[] arr = new int[n+1];
        int answer =0;
        for(int i = 2 ; i<= n ; i++){
            //처음보는거면(0이면) 소수갯수 추가
            if(arr[i]==0){
                answer++;
            }
            //본것과 그 배수들을 모두 1로 해서 지운다.
            for(int j = i ; j<=n ; j+=i)
                arr[j]=1;
        }
        return answer;
    }

    public static void main(String[] args){
        eratosthenes E = new eratosthenes();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        System.out.println(E.solution(n));
    }
}
