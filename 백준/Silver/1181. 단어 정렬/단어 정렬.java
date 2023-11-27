import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Set<Word> list = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Word(st.nextToken()));
        }

        for (Word word : list) {
            sb.append(word.word).append("\n");
        }

        System.out.println(sb);
    }

    static class Word implements Comparable<Word>{
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if(this.word.length() == o.word.length()){
                return word.compareTo(o.word);
            }
            else {
                return this.word.length() - o.word.length();
            }
        }
    }
}