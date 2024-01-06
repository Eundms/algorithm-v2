import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int T;
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for(int testCase = 1; testCase <= T; testCase++) {
			// 류재명이 있을 수 있는 위치
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());//조규현
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken()); // 류재명과의 거리
			
			int x2 = Integer.parseInt(st.nextToken());//백승환
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			System.out.println(find(x1,y1,r1,x2,y2,r2));
			
		}
		
	}
	public static int find(int x1, int y1, int r1, int x2, int y2, int r2) {
		if(x1==x2 && y1== y2 && r1 == r2) {
			return -1;
		}else if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) > (r1+r2)*(r1+r2)) {
			return 0;
		}else if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) < (r2-r1)*(r2-r1)) {
			return 0;
		}else if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == (r2-r1)*(r2-r1)) {
			return 1;
		}else if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == (r2+r1)*(r2+r1)) {
			return 1;
		}
		return 2;
	}
}