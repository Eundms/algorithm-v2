import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int P; // 테스트 케이스의 수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int[] height = new int[20];
			for(int j = 0; j < 20 ; j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}
			int moveCnt = 0;
			List<Integer> answer = new ArrayList<>();
			answer.add(height[0]);
			for(int j = 1; j < 20 ; j++) {
				boolean findAnswer = false;
				for(int k = 0; k < j; k++) {
					if(height[j] < answer.get(k)) {
						moveCnt += answer.size()-k;
						answer.add(k, height[j]);
						findAnswer = true;
						break;
					}
				}
				if(!findAnswer) {
					answer.add(height[j]);
				}
			}
			sb.append(idx+" "+moveCnt+"\n");
		}
		System.out.println(sb.toString());
	}



}