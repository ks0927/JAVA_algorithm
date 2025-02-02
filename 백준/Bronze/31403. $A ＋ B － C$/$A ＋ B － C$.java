import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(A + B - C);

        String AB = String.valueOf(A) + String.valueOf(B);
        System.out.println(Integer.parseInt(AB) - C);
    }
    
}
