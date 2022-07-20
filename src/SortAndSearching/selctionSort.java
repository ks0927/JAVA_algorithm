package SortAndSearching;

import java.util.Scanner;

public class selctionSort {
    public int[] solution(int n,int[] arr){
        int min;
        for(int i=0; i<n;i++){ //arr를0부터n까지 도는데
            min=arr[i];   //i번째 값을
            for(int j =i+1;j<n;j++){ //i-1 ~ n까지 돌면서
                if(min>arr[j]){  // i번째 값보다 작은값이 있으면
                    int tmp= min;
                    min=arr[j];  //그값을 가져오고
                    arr[j]=tmp;  //자리를 바꾼다.
                    arr[i]=min;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args){
        selctionSort S = new selctionSort();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();

        for(int x: S.solution(n,arr))
            System.out.print(x+" ");
    }
}
