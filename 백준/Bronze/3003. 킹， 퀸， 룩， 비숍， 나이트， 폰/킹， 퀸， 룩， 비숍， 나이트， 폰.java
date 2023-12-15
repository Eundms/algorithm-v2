import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
class Main { 	
	static int[] ans = {1,1,2,2,2,8};
	static int[] box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		box = new int[6];
		for(int i = 0; i < 6; i++) {
			box[i] = ans[i]-Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 6; i++) {
			System.out.print(box[i]+" ");
		}
		System.out.println();
	}

}


 