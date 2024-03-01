
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int T;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			System.out.println(modExp(a,b,10));
		}
	}
	static int modExp(int a, int b, int m) {
		int result = 1;
		a = a % m;
		while(b > 0) {
			if(b % 2 == 1) {
				result = (result * a) % m;
			}
			b = b/2;
			a = (a * a)% m;
		}
		return result == 0 ? 10 : result;
	}
}
