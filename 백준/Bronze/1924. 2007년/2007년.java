import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 0;
        for (int i = 0; i < x - 1; i++) {
            day += month[i];
        }
        day += y;

        String[] date = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(date[day % 7]);

    }
}
