package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj17140 {

    static class Point implements Comparable<Point>{
        int num;
        int count;

        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {       //this - o 면 오름차순 , o-this면 내림차순인듯하다
            if(this.count == o.count) {
                return this.num - o.num;
            }
            else {
                return this.count - o.count;
            }
        }
    }

    static int[][] map;
    static int R;
    static int C;
    static int K;
    static int time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()) -1; //인덱스 편의상 -1
        C = Integer.parseInt(st.nextToken()) -1; //인덱스 편의상 -1
        K = Integer.parseInt(st.nextToken());

        map = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }
        
        time =-1;
        while(time <=100){
            ++time;

            if(0<=R && R<map.length && 0<=C && C<map[0].length && map[R][C]==K){
                break;
            }

            //map.length는 행의 갯수, map[0].length는 열의 갯수이다.
            //행의 갯수가 열의갯수보다 많거나 같으면 R연산을 해야한다.
           if(map.length >= map[0].length){
               operationR();
           }
           else{
               operationC();
           }

        }

        if(time>100){
            time = -1;
        }

        System.out.println(time);


    }

    static void operationR() {
        ArrayList<Point> rowList;

        int maxColumnSize =0;

        for (int i = 0; i < map.length; i++) {
            Map<Integer,Integer> numberNode = new HashMap<>();

            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0)
                    continue;
                numberNode.put(map[i][j], numberNode.getOrDefault(map[i][j],0)+1); //맵에 키값으로 숫자를 넣고 없다면 0으로초기화후 +1,있어도 +1
            }

            rowList = new ArrayList<>();
            for (Integer integer : numberNode.keySet()) {
                rowList.add(new Point(integer,numberNode.get(integer))); //리스트에 지금까지 구한 숫자와 숫자갯수를 담고
            }

            Collections.sort(rowList); // 해당 리스트를 정렬하는데 정렬하는 법은 위에 Point 클래스에 compareTo로 구현되어있다.

            maxColumnSize=Math.max(maxColumnSize,rowList.size()*2); //row의 행size 크기를 재는데 현재 사이즈는 rowList.size의 2배이다 왜냐면 숫자,숫자갯수 이기때문

            map[i] = new int[maxColumnSize]; //맵의 현재 row를 새로 만들고

            //맵의 현재row를 초기화 해준다.
            int index =0;
            for (Point point : rowList) {
                map[i][index] = point.num;
                ++index;
                map[i][index] = point.count;
                ++index;

                if(index>= 100) //근데 만약 인덱스가 100을넘어가면 더이상 초기화 그만
                    break;
            }
/*            System.out.println("현재 map "+i+"열의 값들");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }*/
        }

        //다 돌고나면 아마 map의 row마다 행의 사이즈가 들쭉날쭉한텐데 이걸 가장큰거 기준으로 복사를 해서 크기를 맞춰주자.
        for (int i = 0; i < map.length; i++) {
            while(map[i].length< maxColumnSize){
                int[] temp = Arrays.copyOf(map[i], maxColumnSize);
                map[i]= new int[maxColumnSize];
                map[i]=Arrays.copyOf(temp,maxColumnSize);
            }
        }
/*        System.out.println("현재 map의 값들");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < maxColumnSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

    }
    static void operationC() {
        ArrayList<Point> columnList;

        int maxRowSize = 0;
        int[][] temp = new int[100][100];

        for (int i = 0; i < map[0].length; i++) { //i는 행
            Map<Integer, Integer> numberNode = new HashMap<>();

            for (int j = 0; j < map.length; j++) { //j는 열
                if (map[j][i] == 0)
                    continue;
                numberNode.put(map[j][i], numberNode.getOrDefault(map[j][i], 0) + 1); //맵에 키값으로 숫자를 넣고 없다면 0으로초기화후 +1,있어도 +1
            }

            columnList = new ArrayList<>();
            for (Integer integer : numberNode.keySet()) {
                columnList.add(new Point(integer, numberNode.get(integer))); //리스트에 지금까지 구한 숫자와 숫자갯수를 담고
            }

            Collections.sort(columnList); // 해당 리스트를 정렬하는데 정렬하는 법은 위에 Point 클래스에 compareTo로 구현되어있다.

            maxRowSize = Math.max(maxRowSize, columnList.size() * 2); //row의 행size 크기를 재는데 현재 사이즈는 rowList.size의 2배이다 왜냐면 숫자,숫자갯수 이기때문

            //맵의 현재row를 초기화 해준다.
            int index = 0;
            for (Point point : columnList) {
                temp[index][i] = point.num;
                ++index;
                temp[index][i] = point.count;
                ++index;

                if (index >= 100) //근데 만약 인덱스가 100을넘어가면 더이상 초기화 그만
                    break;
            }

        }
        map = new int[maxRowSize][map[0].length];
        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.copyOf(temp[i],map[0].length);
        }

/*        System.out.println("현재 map의 값들");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/
    }

}
