package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class rockScissorPaper {

    public ArrayList<String> solution(int[] arr1, int[] arr2){
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0 ;i<arr1.length; i++){
            if((arr1[i]==1&&arr2[i]==3) || (arr1[i]==2&&arr2[i]==1) || (arr1[i]==3&&arr2[i]==2))
                answer.add("A");
            else if(arr1[i]==arr2[i])
                answer.add("D");
            else
                answer.add("B");
        }
        return answer;
    }

    public static void main(String[] args){
        rockScissorPaper R = new rockScissorPaper();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i<n ; i++)
            arr1[i] = kb.nextInt();
        for(int i=0; i<n ; i++)
            arr2[i] = kb.nextInt();

        for(String x : R.solution(arr1,arr2)){
            System.out.println(x);
        }

    }
}
