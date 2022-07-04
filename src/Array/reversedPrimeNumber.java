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

    public ArrayList<Integer> soultion(String[] arr){
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

    public static void main(String[] args){
        reversedPrimeNumber R = new reversedPrimeNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];

        for(int i= 0; i< arr.length; i++)
            arr[i] = kb.next();

        for(int x : R.soultion(arr)){
            System.out.print(x+" ");
        }

    }
}
