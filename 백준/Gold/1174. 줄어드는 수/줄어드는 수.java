import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean flag = true;
    static ArrayList<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        calcul();
        Collections.sort(list);
        if(N > list.size()){
            System.out.println(-1);
        }else {
            System.out.println(list.get(N - 1));
        }
    }

    private static void calcul() {

        list = new ArrayList<>();
        int index = 1;
        while (flag) {
            if (index > 10)
                break;

            for (int i = 0; i < 10; i++) {
                indexCal(index, 1, i, String.valueOf(i));
            }

            index++;
        }

    }

    private static void indexCal(int index, int nowIndex, int nowNum, String value) {

        if (nowIndex == index) {
            list.add(Long.parseLong(value));
        } else {
            for (int i = nowNum + 1; i < 10; i++) {
                indexCal(index, nowIndex + 1, i, i + value);
            }
        }

    }


}
