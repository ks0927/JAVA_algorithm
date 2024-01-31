import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = 0;

        while(B != A) {
//            System.out.println("B = " + B);

            //B가 범위밖으로 나가면 -1 반환
            if(B < A){
                System.out.println(-1);
                return;
            }
            //B가 2로 나눠지면 나눈다.
            if (B % 2 == 0) {
                B = B / 2;
                result++;
            }
            //B가 2로 안나눠질때
            else {
                String stringB = String.valueOf(B);
                int length = stringB.length();
                String lastBNumber = String.valueOf(stringB.charAt(length - 1));

                // 만약 끝값이 1이 아니라면 -1 반환
                if(!(lastBNumber.equals("1"))){
                    System.out.println(-1);
                    return;
                }

                String substringB = stringB.substring(0, length - 1);
                int intB = Integer.parseInt(substringB);
//                System.out.println("intB = " + intB);
                B = intB;
                result++;
            }
        }

        result++;
        System.out.println(result);
    }
}
