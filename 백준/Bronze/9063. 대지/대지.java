import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N;
	public static void main(String[] args)throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		for(int n = 0; n < N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
			
		}
		System.out.println((maxX - minX) * (maxY - minY));

	}	

}
 