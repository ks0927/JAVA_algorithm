import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String readLine = br.readLine();

            if (readLine.equals("0")) {
                break;
            }

            boolean flag = true;
            int length = readLine.length();
            int middle = length / 2;

            int end = length - 1;
            for (int i = 0; i < middle; i++) {
                if(readLine.charAt(i) != readLine.charAt(end-i)){
                    sb.append("no").append("\n");
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);

    }
}
