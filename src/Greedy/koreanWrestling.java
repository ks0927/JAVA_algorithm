package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class koreanWrestling {
    public int solution(int n,int[][] arr) {
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]); //양수일땐 내림차순, 음수일땐 오름차순? o1-o2를 한다고 생각하자?o2가 o1보다 크다고 생각하고?
            } else {
                return Integer.compare(o2[0], o1[0]);
            }
        }));

/*        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }*/
        int max =Integer.MIN_VALUE;
        int answer=0;
        for (int i = 0; i < n; i++) {
            if(arr[i][1]>max){
                max=arr[i][1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        koreanWrestling K = new koreanWrestling();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++)
                arr[i][j]= kb.nextInt();
        }
        System.out.print(K.solution(n,arr));
    }
}
