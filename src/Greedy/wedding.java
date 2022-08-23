package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TimeStatus implements Comparable<TimeStatus>{
    int time;  //시간
    int status;  //상태 , 0일때 나감, 1일때 입장

    public TimeStatus(int time, int status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(TimeStatus o) {
        if(this.time == o.time){
            return this.status -o.status; //time이 같을때는 status 기준으로 내림차순
        }
        else{
            return this.time - o.time;  //time 메인 기준으로 내림차순
        }
    }
}
public class wedding {

    public int solution(List<TimeStatus> list){
        Collections.sort(list); //이러면 내가만든 기준에 따라서 정렬해주겠지
        int people =0;
        int max =Integer.MIN_VALUE;
        for (TimeStatus timeStatus : list) {
//            System.out.println(timeStatus.time+" "+timeStatus.status);
            if(timeStatus.status==1) {people++;}
            if(timeStatus.status==0) {people--;}
            if(people>max) {max = people;}
        }
        return max;
    }


    public static void main(String[] args) {
        wedding W = new wedding();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<TimeStatus> list =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start_time = kb.nextInt();
            int out_time = kb.nextInt();
            list.add(new TimeStatus(start_time,1));
            list.add(new TimeStatus(out_time,0));
        }
        System.out.print(W.solution(list));
    }
}
