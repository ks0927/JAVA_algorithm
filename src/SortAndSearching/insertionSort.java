package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class insertionSort {
    public int[] solution(int n, int[] arr){
        for(int i=1;i<n;i++) { //i는 1부터 시작
            int tmp = arr[i];  //확인할 값
            int j;  //확인할 값의 이전 위치들
            for (j = i - 1; j >= 0; j--) {
                if (tmp < arr[j])   //만약 확인할 값과 그전 값을 비교해서 그전값이 크면 앞값을 그전값과 동일하게 한다.즉 이동시킨다. ex) 5 9 7 ->5 9 9
                    arr[j + 1] = arr[j];
                else
                    break;  //확인할 값이  더 크거나 같으면 break로 멈추고 해당 인덱스값(j+1)을 기억한다.
            }
            arr[j + 1] =tmp;  // 기억한 인덱스 값을 통해 확인할 값을 넣어준다.
        }

        return arr;

    }

    public static void main(String[] args){
        insertionSort I = new insertionSort();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();

        for(int x: I.solution(n,arr))
            System.out.print(x+" ");
    }
}
