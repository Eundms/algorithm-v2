import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int L, P;
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		

		st = new StringTokenizer(br.readLine());
		int[] temp = new int[5];
		for(int i = 0; i < 5; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.print((temp[i]- L*P)+" ");
		}
	}
}
