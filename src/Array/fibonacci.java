package Array;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacci {
    private static int[] solution(int n) {
        int[] answer= new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int i= 2; i< n ; i++){
            answer[i]= answer[i-2] +answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args){
        fibonacci F = new fibonacci();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = solution(n);
        for(int x : arr){
            System.out.print(x+" ");
        }
    }

}
