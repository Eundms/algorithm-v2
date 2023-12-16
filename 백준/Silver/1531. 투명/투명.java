import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main { 	
	
	static int N,M;
	static int[][] box = new int[100][100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 후보의 수  
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			
			for(int x = sx; x <= ex; x++) {
				for(int y = sy; y <= ey; y++) {
					box[x][y] += 1;
				}
			}
		}
		int cnt = 0;
		//M개 초과
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(box[i][j]>M)cnt+=1;
			}
		}
		System.out.println(cnt);
		
	}


}


 