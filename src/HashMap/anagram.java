package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class anagram {
    public void solution(String str1,String str2){
        Map<Character,Integer> map = new HashMap<>();
        int difference=0;

        for(Character x : str1.toCharArray())
            map.put(x,map.getOrDefault(x,0)+1);
        for(Character x : str2.toCharArray())
            map.put(x,map.getOrDefault(x,-1)-1);

        for(int x: map.values()){
            if(x!=0)
                difference++;
        }
        if(difference!=0)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    public static void main(String[] args){
        anagram A = new anagram();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();
        A.solution(str1,str2);
    }
}
