import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N - 1 - i; j++) {
                sb.append(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }


            sb.append("\n");
        }

        System.out.println(sb);

    }


}
