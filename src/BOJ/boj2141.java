package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj2141 {

    static class Country implements Comparable<Country>{
        int i;
        int people;

        public Country(int i, int people) {
            this.i = i;
            this.people = people;
        }

        @Override
        public int compareTo(Country o) {
            return this.i - o.i;
        }

/*        @Override
        public String toString() {
            return "Country{" +
                    "i=" + i +
                    ", people=" + people +
                    '}';
        }*/
    }
    static int N;
    static List<Country> country;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        country = new ArrayList<>();

        Long allPeople = 0L;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            allPeople += people;

            country.add(new Country(index,people));
        }

        Collections.sort(country);

/*        for (Country country1 : country) {
            System.out.println("country1 = " + country1);
        }*/

        Long halfAllPeople = (allPeople + 1) / 2;

        // 우체국이 좌우에 같거나 비슷한 숫자가 형성되는 고른 상태일때 최소값이 나올것이라 예상
        // 그렇기에 모든 사람의 수의 절반이 넘거나 같은 상황이 된순간의 마을의 번지를 반환한다.
       Long countPeople = 0L;
        for (int i = 0; i < N; i++) {

            int nowPeople = country.get(i).people;
            countPeople += nowPeople;
            if(countPeople >= halfAllPeople){
                System.out.println(country.get(i).i);
                break;
            }
        }
    }
}
