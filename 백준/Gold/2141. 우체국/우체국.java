import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static class Point implements Comparable<Point> {
        long index;
        long people;

        public Point(long index, long people) {
            this.index = index;
            this.people = people;
        }


        @Override
        public int compareTo(Point o) {
            return Long.compare(this.index, o.index);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Point> map = new ArrayList<>();

        long allPeople = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long v1 = Long.parseLong(st.nextToken());
            long v2 = Long.parseLong(st.nextToken());
            allPeople+= v2;
            map.add(new Point(v1, v2));
        }

        Collections.sort(map);

        long check = (allPeople %2 == 0)? allPeople/2 : (allPeople+1)/2;
        long sum = 0;

        long result = -1;
        for (Point point : map) {
            sum += point.people;

            if(sum >= check) {
                result = point.index;
                break;
            }
        }

        System.out.println(result);
    }
}



