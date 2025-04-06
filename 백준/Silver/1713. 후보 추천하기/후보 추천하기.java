import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N, M;

    static class Student implements Comparable<Student> {
        int who;
        int count;
        int index;

        public Student(int who, int count, int index) {
            this.who = who;
            this.count = count;
            this.index = index;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count != o.count)
                return Integer.compare(this.count, o.count);
            return Integer.compare(this.index, o.index);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        HashMap<Integer, Student> candidate = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (candidate.containsKey(cur)) {
                candidate.put(cur, new Student(cur, candidate.get(cur).count + 1, candidate.get(cur).index));
            } else {

                if (candidate.size() < N) {
                    candidate.put(cur, new Student(cur, 1, i));
                } else {
                    List<Student> valueSet = new ArrayList<>(candidate.values());

                    Collections.sort(valueSet);

                    Student remove = valueSet.get(0);
                    candidate.remove(remove.who);

                    candidate.put(cur, new Student(cur, 1, i));
                }
            }
        }

        List<Integer> keySet = new ArrayList<>(candidate.keySet());
        Collections.sort(keySet);

        StringBuilder sb = new StringBuilder();
        for (Integer i : keySet) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
