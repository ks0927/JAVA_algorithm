package TwoPointers;

import java.util.Scanner;

public class maxSales {
    public int solution(int n , int k, int[] arr){
        int max = 0;
        int answer =0;
        //초기 sliding window 값 설정
        for(int i=0; i<k; i++)
            max+=arr[i];
        answer=max;

        //한칸씩 밀면서 max값 초기화
        for(int i= k; i<n ; i++){
            max+= (arr[i]-arr[i-k]);
            if(max>answer)
                answer = max;
        }
        return answer;
    }

    public static void main(String[] args){
        maxSales M = new maxSales();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i< arr.length; i++)
            arr[i]= kb.nextInt();

        System.out.println(M.solution(n,k,arr));
    }
}
