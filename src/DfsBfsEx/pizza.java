package DfsBfsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pizza {
    static List<Point> pizza;
    static List<Point> house;
    static int[][] map;
    static int[] pizza_combi;
    static int m;
    static int len;
    static int min=Integer.MAX_VALUE;
    public void DFS(int L,int start){
        if(L==m){
            int sum=0;
            for(Point house_point : house){
                int dis=Integer.MAX_VALUE;
                for(int p_c : pizza_combi){ //만든 피자집 조합에서 피자집 하나 뽑아온다
                    int temp_X = Math.abs(house_point.x - pizza.get(p_c).x);
                    int temp_Y = Math.abs(house_point.y - pizza.get(p_c).y);

                    dis=Math.min(dis, temp_X+temp_Y); //뽑아온 하나의 피자집에서 가장 가까운 집
                }
                sum+=dis;
            }
            min=Math.min(min, sum); //min값 과 sum 값을 비교해서 작은값을 min으로 계속 초기화해준다.
        }
        else{
            for (int i = start; i < len; i++) {  //결국 이전 combiList와 같은 원리
                pizza_combi[L]=i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        pizza P = new pizza();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        m = kb.nextInt();
        map = new int[n][n];
        pizza = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                map[i][j]= kb.nextInt();
                if(map[i][j]==1){
                    house.add(new Point(j,i));
                }
                if(map[i][j]==2){
                    pizza.add(new Point(j,i));
                }
            }
        }
        len = pizza.size();
        pizza_combi= new int[m];
        P.DFS(0,0);
        System.out.print(min);

    }
}
