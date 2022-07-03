package Array;

import java.util.Scanner;

public class biggerStudent {

    public int solution(int[] arr){
        int answer = 1;
        int max=arr[0];
        for(int i=0; i<arr.length ; i++){
            if(arr[i]>max){
                max=arr[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){

        biggerStudent B = new biggerStudent();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i =0 ; i<arr.length ; i++){
            arr[i]= kb.nextInt();
        }

        System.out.println(B.solution(arr));
    }
}
