import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, int[]> way = new HashMap<>();
	static int N,M;
	static int[][] box =  new int[8][8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 알파벳 : 열
		// 숫자 : 행
		String king = st.nextToken(); // 킹의 위치
		int kRow = 7-(king.charAt(1)-'1');
		int kCol =king.charAt(0)-'A';
		String rock = st.nextToken(); // 돌의 위치
		int rRow = 7-(rock.charAt(1)-'1');
		int rCol = rock.charAt(0)-'A';
	
		initWay();
		int N = Integer.parseInt(st.nextToken());
		for(int n = 0; n < N; n++) { // 움직이는 횟수
			String move = br.readLine();
			int nx = kRow + way.get(move)[0];
			int ny = kCol + way.get(move)[1]; 
			// 밖으로 나갈 경우 이동 건너 뜀
			if(nx<0 || nx>=8 || ny<0 || ny>=8)continue;
			// 킹이 돌이랑 같은 곳으로 이동하면, 돌을 같은 방향으로 한 칸 이동한다
			if(rRow == nx && rCol == ny) {
				int rnx = rRow + way.get(move)[0];
				int rny = rCol + way.get(move)[1];
				if(rnx<0 || rnx>=8 || rny<0 || rny >= 8) {continue;}
				rRow = rnx;
				rCol = rny;
			}
			kRow = nx;
			kCol = ny;
		}
		System.out.println((char)('A'+kCol)+""+(char)('8'-kRow));
		System.out.println((char)('A'+rCol)+""+(char)('8'-rRow));
		
	}
	static void initWay() {
		way.put("R", new int[] {0,1});
		way.put("L", new int[] {0,-1});
		way.put("B", new int[] {1,0});
		way.put("T", new int[] {-1,0});
		way.put("RT", new int[] {-1,1});
		way.put("LT", new int[] {-1,-1});
		way.put("RB", new int[] {1,1});
		way.put("LB", new int[] {1,-1});

	}
}