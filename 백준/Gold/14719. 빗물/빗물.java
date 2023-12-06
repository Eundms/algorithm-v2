import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int[] box;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // 세로 길이
		int W = Integer.parseInt(st.nextToken()); // 가로 길이

		st = new StringTokenizer(br.readLine());
		box = new int[W];
		for(int w = 0; w < W; w++) {
			box[w] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		// 기준에서 나보다 크거나 같은 블록까지
		for(int w = 1 ; w < W-1; w++) {
			int leftMax = 0;
			int rightMax = 0;
			
			for(int i = 0; i < w; i++) {
				leftMax = Math.max(leftMax, box[i]);
			}
			
			for(int j = w+1; j < W; j++) {
				rightMax = Math.max(rightMax, box[j]);
			}
			
			if(box[w]<leftMax && box[w]<rightMax) {
				result += Math.min(leftMax, rightMax)-box[w];				
			}
			
		}
		System.out.println(result);
	}
}