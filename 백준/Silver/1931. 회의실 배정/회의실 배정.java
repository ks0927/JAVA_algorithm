import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<MeetingRoom> roomList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roomList.add(new MeetingRoom(start, end));
        }

        Collections.sort(roomList);

        int check = 0;
        int result = 0;
        for (MeetingRoom meetingRoom : roomList) {
            if(check <= meetingRoom.start) {
                check = meetingRoom.end;
                result++;
            }
        }

        System.out.println(result);
    }

    static class MeetingRoom implements Comparable<MeetingRoom> {
        int start;
        int end;

        public MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingRoom o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

}

