import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            sb.append(Decode(code.charAt(i)));
        }

        System.out.println(sb);

    }

    private static char Decode(char c) {
        return (char) ((c - 'A' + 23) % 26 + 'A');
    }
    private static char Encode(char c) {
        return (char) ((c - 'A' + 3) % 26 + 'A');
    }

}

