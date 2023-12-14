import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int twoCount = 0;
        int fiveCount = 0;
        for (int i = 1; i <= N; i++) {
            int tempTwo =i;
            int tempFive =i;
            while (true){

                if(tempTwo%2 ==0){
                    twoCount++;
                    tempTwo/=2;
                }

                if(tempFive%5 ==0){
                    fiveCount++;
                    tempFive/=5;
                }

                if(tempTwo % 2 !=0 && tempFive % 5 != 0)
                    break;
            }
        }

        System.out.println(Math.min(twoCount,fiveCount));
    }

}
