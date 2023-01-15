package TwoPointers;

import java.util.Scanner;

public class continuousNumber {
    public int solution(int n){
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = i + 1;

        int cnt1=0, cnt2=0;
        int tmp=0;
        int answer=0;

        while(cnt1<n && cnt2<n){
            tmp+=arr[cnt2];
            cnt2++;
            if(tmp>n){
                tmp=0;
                cnt1++;
                cnt2=cnt1;
            }
            if(tmp==n){
                answer++;
                tmp=0;
                cnt1++;
                cnt2=cnt1;
            }
        }
        return answer-1; //1개로 구성된 합은 제외

    }

    public static void main(String[] args){
        continuousNumber C = new continuousNumber();
        Scanner kb = new Scanner(System.in);

        int n  = kb.nextInt();
        System.out.println(C.solution(n));
    }
}
