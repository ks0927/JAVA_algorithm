package Array;

import java.util.Scanner;

public class scoreCalculate {
    public int soultion(int[] arr){
        int tmp =0;
        int answer = 0;
        for(int x : arr){
            if(x==1){
                tmp++;
                answer+=tmp;
            }
            else {
                tmp = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        scoreCalculate S = new scoreCalculate();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i= 0; i< arr.length ; i++)
            arr[i]= kb.nextInt();

        System.out.println(S.soultion(arr));
    }
}
