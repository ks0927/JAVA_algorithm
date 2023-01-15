package TwoPointers;

import java.util.Scanner;

public class continuousPartialSequence {
    //뭔가 엉성한 two pointer
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
    // two pointer와 sliding window의 결합
    public int solution2(int n, int m, int[] arr){
        int answer=0, sum=0, lt=0, rt;
        for(rt=0; rt<n; rt++){
            sum+=arr[rt]; //하나씩 추가
            if(sum==m) answer++; //조건에 부합할때 +1
            while(sum>=m){ //초과되었을때
                sum-=arr[lt++]; //앞에서 부터 줄임 sliding window
                if(sum==m) answer++; //줄였을때 조건에 부합할수도있으니까
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
        System.out.println(C.solution2(n,m,arr));
    }
}
