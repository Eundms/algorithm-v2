import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] box = new int[3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int line = 0; line < 3; line++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int zeroCnt = 0;
			for(int i= 0; i < 4; i++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur == 0) {
					zeroCnt+=1;
				}
			}	
			System.out.println(getResult(zeroCnt));
		}
		
		
	}
	static char getResult(int zeroCnt) {
		if(zeroCnt == 1) {
			return 'A';
		}else if(zeroCnt ==2) {
			return 'B';
		}else if(zeroCnt == 3) {
			return 'C';
		}else if(zeroCnt == 4) {
			return 'D';
		}
		
		return 'E';
	}

}

 