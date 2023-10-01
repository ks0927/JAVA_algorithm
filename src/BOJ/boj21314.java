package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21314 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String MKString = st.nextToken();

        String BigResult = "";
        int countM = 0;

        //가장 큰 값 찾는 루프
        for (int i = 0; i < MKString.length(); i++) {
            String nowString = String.valueOf(MKString.charAt(i));

            // M일때
            if(nowString.equals("M")){
                countM++;
            }
            // K일때
            else {

                BigResult+="5";

                if(countM == 0){
                    continue;
                }

                for (int j = 0; j < countM; j++) {
                    BigResult+="0";
                }
                countM = 0;
            }

        }
        // 예를들어 MM 이 남았을때 10 보단 11이 더 큰값일것.
        if(countM!=0){
            for (int i = 0; i < countM; i++) {
                BigResult+="1";
            }
        }
        System.out.println(BigResult);


        countM = 0;
        String smallResult = "";
        //가장 작은 값 찾는 루프
        for (int i = 0; i < MKString.length(); i++) {
            String nowString = String.valueOf(MKString.charAt(i));

            // M일때
            if(nowString.equals("M")){
                countM++;
            }
            // K일때
            else {

                if(countM != 0){
                    smallResult+="1";
                    for (int j = 0; j < countM - 1; j++) {
                        smallResult+="0";
                    }
                    countM = 0;
                    smallResult+="5";
                }
                else {
                    smallResult+="5";
                }
            }

        }
        // 예를들어 MM 이 남았을때 11 보단 10이 더 작은값일것.
        if(countM!=0){
            smallResult+="1";
            for (int j = 0; j < countM - 1; j++) {
                smallResult+="0";
            }
        }
        System.out.println(smallResult);
    }
}
