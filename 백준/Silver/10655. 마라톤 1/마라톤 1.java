import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N; // 마라톤 코스 N개의 체크포인트로 구성
	static Point[] points;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 체크포인트의 수 
		points = new Point[N];
		for(int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 체크포인트 i의 x좌표
			int y = Integer.parseInt(st.nextToken());	// 체크포인트 i의 y좌표
			points[i] = new Point(x,y);
		}
		int totalDist = 0;
		for(int i = 1; i < N ; i++) {
			totalDist += Math.abs(points[i].x - points[i-1].x) + Math.abs(points[i].y - points[i-1].y);
		}
		
		int minDist = totalDist;
		for(int i = 1; i < N - 1; i++) {
			int jumpDist = Math.abs(points[i+1].x - points[i-1].x) + Math.abs(points[i+1].y - points[i-1].y);
			int diff = Math.abs(points[i+1].x - points[i].x) + Math.abs(points[i+1].y - points[i].y)
			 + Math.abs(points[i].x - points[i-1].x) + Math.abs(points[i].y - points[i-1].y);
			minDist = Math.min(minDist, totalDist + jumpDist - diff);
		}
		System.out.println(minDist);
	}
	static class Point {
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}