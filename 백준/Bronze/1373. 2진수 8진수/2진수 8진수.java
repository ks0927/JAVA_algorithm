import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = value.length(); i > 0; i -= 3) {
            int start = Math.max(0, i - 3);
            String substring = value.substring(start, i);
            sb.append(Integer.toString(Integer.parseInt(substring, 2), 8));
        }
        
        System.out.println(sb.reverse());
    }
}