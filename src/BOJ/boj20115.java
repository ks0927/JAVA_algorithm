package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj20115 {

    static int N;
    static List<Double> drinks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        drinks = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            double drink = Double.parseDouble(st.nextToken());
            drinks.add(drink);
        }
        //오름차순 정렬
        Collections.sort(drinks);

        //드링크 리스트의 사이즈가 1이 될떄까지 반복
        while(drinks.size() != 1){
            int size = drinks.size();

            //맨앞의 가장 작은양의 드링크를 반으로 나눠서 맨뒤에있는 가장큰 드링크에 + 해준다.
            Double smallDrink = drinks.get(0);
            double halfSmallDrink = smallDrink / 2.0;
            double plus = drinks.get(size - 1) + halfSmallDrink;

            drinks.remove(size-1);
            drinks.remove(0);

            drinks.add(plus);

/*            for (Double drink : drinks) {
                System.out.println("drink = " + drink);
            }*/
        }

        System.out.println(drinks.get(0));

    }
}
