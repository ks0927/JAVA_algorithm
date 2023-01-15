package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class combineArray {
    public ArrayList<Integer> solution(int n1, int n2, int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt1=0 , cnt2 =0;

        //포인터 두개로 하나씩 넣는다
        while(cnt1<n1  && cnt2<n2){
            if(arr1[cnt1]< arr2[cnt2]){
                answer.add(arr1[cnt1]);
                cnt1++;
            }
            else{
                answer.add(arr2[cnt2]);
                cnt2++;
            }
        }
        //남은거 있으면 집어넣기
        while(cnt1<n1) {
            answer.add(arr1[cnt1]);
            cnt1++;
        }
        //남은거 있으면 집어넣기
        while(cnt2<n2) {
            answer.add(arr2[cnt2]);
            cnt2++;
        }

        return answer;
    }


    public static void main(String[] args){

        combineArray C = new combineArray();
        Scanner kb = new Scanner(System.in);
        int n1 = kb.nextInt();
        int[] arr1 = new int[n1];
        for(int i= 0; i< arr1.length; i++)
            arr1[i]= kb.nextInt();
        int n2 = kb.nextInt();
        int[] arr2 = new int[n2];
        for(int i= 0; i< arr2.length; i++)
            arr2[i]= kb.nextInt();

        for(int x: C.solution(n1,n2,arr1,arr2))
            System.out.print(x+" ");
    }
}
