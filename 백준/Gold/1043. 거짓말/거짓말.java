import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        Set<Integer> realPeople = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int realPerson = Integer.parseInt(st.nextToken());
            realPeople.add(realPerson);
        }

        boolean recheck = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            boolean check = false;

            int[] temp = new int[C];
            for (int j = 0; j < C; j++) {
                int person = Integer.parseInt(st.nextToken());
                map[i][j] = person;
                temp[j] = person;

                if(realPeople.contains(person)) {
                    check = true;
                }
            }

            if(check) {
                for (int j = 0; j < C; j++) {
                    realPeople.add(temp[j]);
                }
                recheck = true;
            }
        }

        while (recheck) {
            recheck = false;
            for (int i = 0; i < M; i++) {
                boolean check = false;
                for (int j = 0; j < N; j++) {
                    if (realPeople.contains(map[i][j])) {
                        check = true;
                    }

                    if (check) {
                        for (int l = 0; l < N; l++) {
                            if(map[i][l] == 0)
                                break;

                            if(!realPeople.contains(map[i][l])) {
                                recheck = true;
                            }
                            realPeople.add(map[i][l]);
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean check = false;
            for (int j = 0; j < N; j++) {
                if(realPeople.contains(map[i][j])) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                result++;
            }
        }

        System.out.println(result);
    }

}
