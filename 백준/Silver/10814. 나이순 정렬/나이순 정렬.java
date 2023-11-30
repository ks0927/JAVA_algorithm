import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<User> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ages = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr.add(new User(ages,i,name));
        }

        Collections.sort(arr);

        for (User user : arr) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }
        System.out.println(sb);
    }

    public static class User implements Comparable<User>{
        int age;
        int index;
        String name;

        public User(int age, int index, String name) {
            this.age = age;
            this.index = index;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            if(this.age == o.age){
                return  this.index - o.index;
            }else {
                return this.age - o.age;
            }
        }
    }
}
