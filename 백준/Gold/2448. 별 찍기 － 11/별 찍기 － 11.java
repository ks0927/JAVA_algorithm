import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        N = scann.nextInt();
        board = new int[N][2 * N - 1];
        StringBuilder sb = new StringBuilder();
        // 로직
        star(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (board[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // r= 3 / c = 5 짜리 사각형을 기반으로 삼각형을 찍는다.
    // n = 3일때 탈출 조건으로 잡고
    public static void star(int r, int c, int n) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 0 && j == 2) { //맨위 꼭짓점
                        board[r + i][c + j] = 1;
                    } else if (i == 1 && (j == 1 || j == 3)) { // 중간 삼각형변
                        board[r + i][c + j] = 1;
                    } else if (i == 2) { //맨아래 삼각형변
                        board[r + i][c + j] = 1;
                    }
                }
            }
        } else { //사각형 3등분으로 본다.
            star(r + 0, c + n / 2, n / 2); // 맨위 사각형
            star(r + n / 2, c + 0, n / 2); // 왼쪽아래 사각형
            star(r + n / 2, c + n, n / 2); // 오른쪽아래 사각형
        }
    }


}
