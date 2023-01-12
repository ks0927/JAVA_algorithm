package Array;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacci {
    //배열을 사용하는 피보나치
    private static int[] solution(int n) {
        int[] answer= new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int i= 2; i< n ; i++){
            answer[i]= answer[i-2] +answer[i-1];
        }

        return answer;
    }
    //배열없이 변수를 통해 사용하는 피보나치
    private void solution2(int n){
        int a = 1;
        int b = 1;
        int c;
        System.out.print(a +" " +b +" ");
        for (int i = 2; i < n; i++) {
            c =a + b;
            System.out.print(c + " ");
            a =b;
            b =c;
        }
    }

    public static void main(String[] args){
        fibonacci F = new fibonacci();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = solution(n);
        for(int x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
        F.solution2(n);
    }

}
