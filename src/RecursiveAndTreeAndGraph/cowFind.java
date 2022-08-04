package RecursiveAndTreeAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cowFind {

    public int solution(int s, int e){

        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited =new boolean[10001]; //기본 초기화 값은 모두 false
        //Arrays.fill(visited,false); // 혹시 모르면 이렇게 boolean배열 초기화가능
        int L =0;
        Q.offer(s);
        while(!Q.isEmpty()){
            int len = Q.size();

            for(int i=0; i<len ;i++){
                int cur = Q.poll();
                int tmp_1 = cur+1;
                int tmp_back = cur-1;
                int tmp_5 = cur+5;

                if(tmp_1 == e || tmp_back == e || tmp_5 == e ){
                    return L+1;
                }
                if(1<=tmp_1 && tmp_1<=10000 && visited[tmp_1]==false){
                    Q.offer(tmp_1);
                    visited[tmp_1]=true;
                }
                if(1<=tmp_back && tmp_back<=10000 && visited[tmp_back]==false){
                    Q.offer(tmp_back);
                    visited[tmp_back]=true;
                }
                if(1<=tmp_5 && tmp_5<=10000 && visited[tmp_5]==false){
                    Q.offer(tmp_5);
                    visited[tmp_5]=true;
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        cowFind C = new cowFind();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();

        System.out.println(C.solution(s,e));
    }
}
