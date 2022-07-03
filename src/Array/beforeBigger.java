package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class beforeBigger {

    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]> arr[i-1])
                answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){

        beforeBigger B = new beforeBigger();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i<arr.length; i++){
            arr[i]= kb.nextInt();
        }

        for(int x : B.solution(arr)){
            System.out.print(x +" ");
        }
    }
}
