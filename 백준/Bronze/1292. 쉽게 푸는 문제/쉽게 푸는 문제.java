
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int A,B;
	public static void main(String[] args) throws Exception{
		// 바람 전파 <- -> 번갈아가면서 존재
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int[] arr = new int[B+1];
		int value = 1;
		int cnt = 0;
		for(int i = 1; i <= B; i++) {
			if(cnt==value) {
				cnt = 0;
				value+=1;
			}
			arr[i] = value;
			cnt +=1;
		}
		int sum = 0;
		for(int i = A; i <= B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
	}
	

}
