import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Position> positions = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            positions.add(new Position(parseInt, i));
        }

        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if (o1.value > o2.value) {
                    return 1;
                } else if (o1.value < o2.value) {
                    return -1;
                }
                return 0;
            }
        });

        int rank = 0;
        int check = positions.get(0).value;
        for (Position position : positions) {
            if (position.value > check) {
                check = position.value;
                rank++;
            }
            position.value = rank;
        }

        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if (o1.index > o2.index) {
                    return 1;
                } else if (o1.index < o2.index) {
                    return -1;
                }
                return 0;
            }
        });

        for (Position position : positions) {
            sb.append(position.value + " ");
        }

        System.out.println(sb);
    }

    static class Position {
        int value;
        int index;

        public Position(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}

