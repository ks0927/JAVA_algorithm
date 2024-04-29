import java.io.*;
import java.util.*;

public class Solution {

    static String[] cards;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cards = st.nextToken().split("");
            int change = Integer.parseInt(st.nextToken());

            if (change > cards.length) {
                change = cards.length;
            }

            max = 0;
            backTracking(0, 0, change);

            sb.append("#").append(i + 1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);

    }

    private static void backTracking(int start, int count, int change) {
        if (count == change) {
            String result = "";
            for (String card : cards) {
                result += card;
            }
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for (int i = start; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                String temp = cards[i];
                cards[i] = cards[j];
                cards[j] = temp;

                backTracking(i, count + 1, change);

                temp = cards[i];
                cards[i] = cards[j];
                cards[j] = temp;
            }
        }
    }


}
