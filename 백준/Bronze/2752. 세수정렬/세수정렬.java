import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] box = new int[3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i= 0; i < 3; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(box);
		for(int i = 0; i < 3; i++) {
			System.out.print(box[i]+" ");
		}
		System.out.println();
	} 

}

 