package TwoPointers;

import java.util.Scanner;

public class maxLengthSequence {
    public int solution(int n, int m,int[] arr){
        int answer =0;
        int cnt=0,lt=0;
        for(int rt=0; rt<n;rt++){
            if(arr[rt]==0)
                cnt++;
            while(cnt>m){
                if(arr[lt]==0)
                    cnt--;
                lt++;
            }
            answer = Math.max(answer,rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args){
        maxLengthSequence M = new maxLengthSequence();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i< arr.length; i++)
            arr[i]= kb.nextInt();

        System.out.println(M.solution(n,m,arr));

    }
}
