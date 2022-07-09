package TwoPointers;

import java.util.*;

public class commonElement {
    public ArrayList<Integer> solution(int n1, int n2, int[] arr1, int[] arr2){
        ArrayList<Integer> answer= new ArrayList<>();
/*        for(int i =0; i<n1; i++){
            for(int j= 0; j<n2; j++){
                if(arr1[i]==arr2[j])
                    answer.add(arr1[i]);
            }
        }
        Collections.sort(answer);*/
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int cnt1=0, cnt2 =0;
        while(cnt1<n1 && cnt2<n2){
            if(arr1[cnt1]==arr2[cnt2]){
                answer.add(arr1[cnt1]);
                cnt1++;
                cnt2++;
            }
            else if(arr1[cnt1]< arr2[cnt2]){
                cnt1++;
            }
            else
                cnt2++;
        }

        return answer;

    }


    public static void main(String[] args){
        commonElement C = new commonElement();
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
