import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 0; i < 2 * N - 1; i++) {

            for (int j = 0; j < -Math.abs(i - (N - 1)) + N; j++) {
                sb.append("*");
            }

            for (int k = 0; k < 2 * N - 2 * (-Math.abs(i - (N - 1)) + N); k++) {
                sb.append(" ");
            }

            for (int j = 0; j < -Math.abs(i - (N - 1)) + N; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }


}
