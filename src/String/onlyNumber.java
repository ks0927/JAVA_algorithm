package String;

import java.util.Scanner;

public class onlyNumber {
    public int solution(String str){
        str = str.replaceAll("[^0-9]","");
        int answer = Integer.parseInt(str);
        return answer;
    }

    public static void main(String[] args){
        onlyNumber O = new onlyNumber();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(O.solution(str));
    }
}
