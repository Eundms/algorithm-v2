import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static int N;
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // N번째 피보나치 수 구하기
		System.out.println(fibo(N));
	}
	static int fibo(int x) {
		if(x <= 1) {
			return x;
		}
		return fibo(x-1)+ fibo(x-2);
	}
}


 

 