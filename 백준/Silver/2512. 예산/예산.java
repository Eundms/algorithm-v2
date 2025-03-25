import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int N; // 지방의 수 
	static int[] money;
	static int MAX_MONEY;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지방의 수
		
		money = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 각 지방의 예산 요청을 표현하는 N개의 정수 : 1이상 100,000 이하
		for(int i = 0; i < N ; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(money);
		// 110 120 140 150
		// 기준 예산보다 작으면, 그대로 + 크면 기준 예산 만큼 <= MAX_MONEY
		// 총 예산 : MAX_MONEY
		MAX_MONEY = Integer.parseInt(br.readLine());
		int res = 0;
		int min = 1;
		int max = money[N-1];
		while(min<=max) {
			int mid = (min + max)/2;
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += Math.min(money[i], mid);
			}
			if(sum <= MAX_MONEY) {
				min = mid + 1;
			}else{
				max = mid -1;
			}
		}
		System.out.println(max);
		
	}


}
