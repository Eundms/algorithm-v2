
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws Exception{
		// 바람 전파 <- -> 번갈아가면서 존재
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
	
		for(int i = 0; i < N ; i++) {
			String file = br.readLine();
			arr[i] = file;
		}
		String[] res = new String[arr[0].length()];
		if(N==1) {
			System.out.println(arr[0]);
			return;
		}
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < arr[i].length(); j++) {
				if(arr[i].charAt(j)==arr[i-1].charAt(j)) {
					if(res[j]==null||res[j].charAt(0)==arr[i].charAt(j)) {
						res[j] = ""+arr[i].charAt(j);
						continue;
					}
				}

				res[j]= "?";
			}
		}
		System.out.println(String.join("", res));
		
	}
	

}
