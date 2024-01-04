import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main { 
	static int N;
	static int douPrice, topingPrice;
	static int douCalorie;
	static int[] topingCalorie;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 토핑의 종류의 수
		StringTokenizer st = new StringTokenizer(br.readLine());// 도우의 가격 A, 토핑의 가격 B
		douPrice = Integer.parseInt(st.nextToken()); // 도우의 가격
		topingPrice = Integer.parseInt(st.nextToken()); // 토핑의 가격
		douCalorie = Integer.parseInt(br.readLine()); 
		
		//피자의 가격 == 도우와 토핑의 가격의 합계
		topingCalorie = new int[N];
		for(int i = 0; i < N; i++) {
			topingCalorie[i] = Integer.parseInt(br.readLine());
		}
		
		
		
		int pizzaCalroie = douCalorie;
		int topingCnt = 0;
		int result = pizzaCalroie/(douPrice + topingPrice * topingCnt);
		Arrays.sort(topingCalorie);
		for(int i = N-1; i >= 0; i--) {
			int pizzaPrice = douPrice + topingPrice * ++topingCnt;
			pizzaCalroie += topingCalorie[i];
			result = Math.max(result, pizzaCalroie/pizzaPrice);
		}
		System.out.println(result);
	}
}