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

        List<Integer> review = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            review.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(review);

        double cut = (N * 15.0) / 100.0;

        int cutting = (int) Math.round(cut);

        int start = cutting;
        int end = N -1 - cutting;

        double sum = 0;
        for (int i = start; i <= end; i++) {
            sum += review.get(i);
        }

        double aver = sum / (end - start + 1);
        long result = Math.round(aver);

        System.out.println(result);
    }


}
