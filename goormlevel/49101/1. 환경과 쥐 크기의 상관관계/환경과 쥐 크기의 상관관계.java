import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] aSpot = new int[100_001];
		int[] bSpot = new int[100_001];

		int aBest = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < T; i++) {
			int mice = Integer.parseInt(st.nextToken());
			aSpot[mice]+=1;
			if(aBest < mice) {
				aBest = mice;
			}
		}

		int bBest = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < T; i++) {
			int mice = Integer.parseInt(st.nextToken());
			bSpot[mice]+=1;
			if(bBest < mice) {
				bBest = mice;
			}
		}

		int aAnswer = getBestSpotValue(aSpot,aBest);
		int bAnswer = getBestSpotValue(bSpot,bBest);

		StringBuilder sb = new StringBuilder();
		sb.append(aAnswer).append(" ").append(bAnswer).append("\n");
		if(aAnswer > bAnswer){
			sb.append("good");
		}else{
			sb.append("bad");
		}

		System.out.println(sb);
	}

	//각 지점의 대표값을 찾는 메서드
	static int getBestSpotValue(int[] spot, int maxValue) {
		int Answer = 0;
		int Sum = 0;

		for(int i = 1; i <= maxValue; i++) {
			int fore = i - 2;
			if(fore < 1){
				fore = 1;
			}

			int back = i + 2;
			if(back > 100_000){
				back = 100_000;
			}

			int sum = 0;
			for(int j = fore; j <= back; j++) {
				sum += spot[j];
			}

			if(Sum < sum) {
				Sum = sum;
				Answer = i;
			}
		}
		return Answer;
	}
}