import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 7; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x % 2 != 0) {
				sum += x;
				min = Math.min(min, x);
			}
			
		}
		if(sum==0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
		
	}
}

