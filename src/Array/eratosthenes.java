package Array;

import java.util.Scanner;

public class eratosthenes {
    public int solution(int n){
        int[] arr = new int[n+1];
        int answer =0;
        for(int i = 2 ; i<= n ; i++){
            if(arr[i]==0){
                answer++;
            }
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
