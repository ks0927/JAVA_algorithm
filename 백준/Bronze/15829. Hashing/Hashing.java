import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String readLine = br.readLine();
        int[] ints = readLine.chars().map(x -> x - 96).toArray();

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum+= ints[i] * calculate(i);
            sum%= 1234567891;
        }
        System.out.println(sum);
    }

    private static int calculate(int target) {
        if(target == 0) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < target; i++) {
            result*=31;
            result%=1234567891;
        }

        return result;
    }

}
