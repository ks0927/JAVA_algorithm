package String;

import java.util.Scanner;

public class palindrome {

    public String solution(String str){
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)){
            return "YES";
        }
        return "NO";

    }

    public static void main(String[] args){
        palindrome P = new palindrome();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        System.out.println(P.solution(str));

    }
}
