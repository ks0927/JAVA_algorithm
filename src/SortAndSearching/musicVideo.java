package SortAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class musicVideo {
    public int solution(int n, int m, int[] arr){
        int least = Arrays.stream(arr).max().getAsInt(); //최소 크기( 가장큰 값이 하나의 dvd를 담당할때)
        int max = Arrays.stream(arr).sum();//모든 곡을 한번에 집어넣는경우
        List<Integer> dvdCount = new ArrayList<>();
        while(least<=max) {
            int tmp = 0;
            for(int x: arr){
                if(dvdCount.size()<=m){
                    if(tmp+x>least ){
                        dvdCount.add(tmp);
                        tmp=x;
                    }
                    else{
                        tmp+=x;
                    }
                }
                else{
                    dvdCount.clear();
                    break;
                }
            }
            if(dvdCount.size()>0) //다돌고 남은거 있을때 , 단 비워진상태가 아닐때 (비워진 상태는 이미 갯수가 least보다 넘어간상황
                dvdCount.add(tmp); //마지막꺼 남아있으니까 넣어줌

/*            for (int y : dvdCount)
                System.out.print(y + " ");
            System.out.print("현least"+least);
            System.out.println();*/
            if (dvdCount.size() <= m && dvdCount.size()!=0) { //5 4 11111 같은 경우를 생각못해서 넣은 조건 ( 작은경우만 가능할때가 존재했었음...원래는 같을때만 생각했는데)
                return least;
            }
            dvdCount.clear();
            least++;

        }
        return -1;
    }

    public static void main(String[] args) {
        musicVideo M = new musicVideo();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();
        System.out.println(M.solution(n,m,arr));
    }
}
