package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class reversedPrimeNumber {

    public boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2 ; i<num; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    // lt와 rt를 이용해서 숫자를 뒤집는 방식 -내방식
    public ArrayList<Integer> solution(String[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(String x : arr){
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length()-1;
            while(lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            int tmp = Integer.parseInt(String.valueOf(s));
            if(isPrime(tmp))
                answer.add(tmp);
        }
        return answer;
    }
    //10으로 나눈 나머지로 숫자를 하나씩 뒤에서 뽑아오는 방식으로 숫자 뒤집기 -강사 방식
    public ArrayList<Integer> solution2(String[] arr,int n){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(arr[i]);
            int res =0;
            while(tmp>0){
                int t = tmp %10;
                res = res * 10 +t;
                tmp = tmp/10;
            }
            if(isPrime(res))
                answer.add(res);

        }
        return answer;
    }

    public static void main(String[] args){
        reversedPrimeNumber R = new reversedPrimeNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];

        for(int i= 0; i< arr.length; i++)
            arr[i] = kb.next();

        for(int x : R.solution(arr)){
            System.out.print(x+" ");
        }
        System.out.println();
        for(int x : R.solution2(arr, arr.length)){
            System.out.print(x+" ");
        }

    }
}
