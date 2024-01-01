import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	static int[] box;
	static int PPL_CNT, AWARD_CNT;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		PPL_CNT = Integer.parseInt(st.nextToken());
		AWARD_CNT = Integer.parseInt(st.nextToken());
		
		box = new int[PPL_CNT];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < PPL_CNT;i++) {
			box[i] = - Integer.parseInt(st.nextToken());
		}

		Arrays.sort(box);
		System.out.println(-box[AWARD_CNT-1]);
		
	}

}