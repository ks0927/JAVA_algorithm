import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st =new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C ==0){
                break;
            }
            sb.append(isRight(A,B,C)).append("\n");
        }

        System.out.println(sb);

    }

    private static String isRight(int a, int b, int c) {

        int tempMax = Math.max(a, b);
        int max = Math.max(tempMax, c);

        if(max == a){
            int i = a * a;
            int i1 = b * b;
            int i2 = c * c;

            if(i == (i1 + i2)){
                return "right";
            }
            else {
                return "wrong";
            }
        }

        if(max == b){
            int i = a * a;
            int i1 = b * b;
            int i2 = c * c;

            if(i1 == (i + i2)){
                return "right";
            }
            else {
                return "wrong";
            }
        }

        if(max == c){
            int i = a * a;
            int i1 = b * b;
            int i2 = c * c;

            if(i2 == (i + i1)){
                return "right";
            }
            else {
                return "wrong";
            }
        }
        return null;
    }
}
