package String;

import java.util.Scanner;

public class onlyNumber {
    //정규식 replaceAll을 사용한 숫자만 골라내기
    public int solution(String str){
        str = str.replaceAll("[^0-9]","");
        int answer = Integer.parseInt(str);
        return answer;
    }
    //아스키 번호를 활용한 골라내기
    public int solution2(String str){
        int answer=0;
        for (char c : str.toCharArray()) {
            if(c>= 48 && c<= 57){
                answer = answer*10 + (c-48);
            }
        }
        return answer;
    }
    //character의 isDigit활용
    public int solution3(String str){
        int answer=0;
        for (char c : str.toCharArray()) {
			if(Character.isDigit(c)){
				answer=answer*10+ Character.getNumericValue(c);
			}
        }
        return answer;
    }


    public static void main(String[] args){
        onlyNumber O = new onlyNumber();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(O.solution(str));
        System.out.println(O.solution2(str));
        System.out.println(O.solution3(str));
    }
}
