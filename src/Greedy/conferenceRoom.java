package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{ //내가 만든 클래스를 sort하려면 Comparable을 impl한다
    public int start, finish;
    Time(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
    @Override
    public int compareTo(Time o){  //무슨 기준으로 sort?
        if(this.finish ==o.finish) return this.start -o.start; //내림차순
        else return this.finish -o.finish; //내림차순
    }
}
public class conferenceRoom {
    public int solution(ArrayList<Time> arr){
        int answer=0;
        Collections.sort(arr);
/*        for (Time time : arr) {
            System.out.println(time.start+" "+time.finish);
        }*/
        int et=0;
        for(Time ob : arr){
            if(ob.start >=et){
                answer++;
                et=ob.finish;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        conferenceRoom T = new conferenceRoom();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start=kb.nextInt();
            int finish=kb.nextInt();
            arr.add(new Time(start, finish));
        }
        System.out.println(T.solution(arr));
    }
}
