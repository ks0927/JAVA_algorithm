package Greedy;

import java.util.Scanner;

public class isFriend {

    public static void main(String[] args) {
//        isFriend U = new isFriend();
        Scanner kb = new Scanner(System.in);

        int cnt_friend = 0;
        int n = kb.nextInt();//학생수
        int m = kb.nextInt();//숫자쌍
        int[] friend = new int[n+1];
        boolean[] check = new boolean[n+1];  //아는 사람인지 체크용

        for (int i = 0; i <= n; i++) {
            friend[i]=i;
        }
        for (int i = 0; i < m; i++) {
            int first_student = kb.nextInt();
            int second_student = kb.nextInt();

            if(check[first_student]==false &&check[second_student]==false){ //처음보는 사람들인가? 즉 새로운 그룹이 만들어지겠구나
                cnt_friend++;
            }

            if(friend[first_student]!=friend[second_student]){
                int tmp_first=friend[first_student];
                int tmp_second=friend[second_student];
                for (int j = 0; j <= n; j++) {       //이 for문은 그룹끼리 연결될때 그 그룹 속 사람들도 다 초기화 시켜주기 위해 만든 for문
                    if(tmp_first==friend[j]){
                        friend[j]=cnt_friend;
                    }
                    if(tmp_second==friend[j]){
                        friend[j]=cnt_friend;
                    }
                }
                friend[first_student]=cnt_friend;
                friend[second_student]=cnt_friend;
                check[first_student]=true;
                check[second_student]=true;
            }
        }
/*        for (int i = 0; i <= n; i++) {
            System.out.println(i+" "+friend[i]);
        }*/
        int check_first = kb.nextInt();
        int check_second = kb.nextInt();
        if(friend[check_first]==friend[check_second])
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
