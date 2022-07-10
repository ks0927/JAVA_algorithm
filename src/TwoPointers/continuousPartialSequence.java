package TwoPointers;

import java.util.Scanner;

public class continuousPartialSequence {
    public int solution(int n, int m, int[] arr){
        int cnt1=0, cnt2=0;
        int tmp=0;
        int answer=0;

        while(cnt1<n && cnt2<n){
            tmp+=arr[cnt2];
            cnt2++;
            if(tmp>m){
                tmp=0;
                cnt1++;
                cnt2=cnt1;
            }
            if(tmp==m){
                answer++;
                tmp=0;
                cnt1++;
                cnt2=cnt1;
            }
        }

        return answer;

    }

    public static void main(String[] args){
        continuousPartialSequence C = new continuousPartialSequence();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i< arr.length; i++)
            arr[i]= kb.nextInt();

        System.out.println(C.solution(n,m,arr));
    }
}
