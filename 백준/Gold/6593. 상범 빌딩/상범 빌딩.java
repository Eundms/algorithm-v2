import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {// 25206 너의 평점은 // 20055 컨베이어 벨트 //2580 스도쿠  //6593 상범빌딩 //3061 사다리  //1080 행렬
	static int L,R,C;
	static char[][][] box;
	static int[][] way = {{1,0,0},{0,1,0},{0,0,1},{-1,0,0},{0,-1,0},{0,0,-1}};
	static char EMPTY = '.', BLOCKED = '#';
	static Position start, end;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0)break;
            box = new char[L][R][C];
            for(int i = 0 ; i < L; i++) {
            	for(int j = 0; j < R; j++) {
                	String str = br.readLine();
            		for(int k = 0; k < C; k++) {
                		box[i][j][k] = str.charAt(k);   
                		if(box[i][j][k]=='S') {
                			start = new Position(i,j,k,0);
                		}else if(box[i][j][k]=='E') {
                			end = new Position(i,j,k,0);
                		}
            		}
            	}
            	br.readLine();
            }
            int time = 0;
            time = escape(time);
            
            if(time > 0) {
                System.out.println("Escaped in "+time+" minute(s).");            	
            }else {
                System.out.println("Trapped!");            	
            }
        }
	}
	static int escape(int time) {
		boolean[][][] visited = new boolean[L][R][C];

		Queue<Position>queue = new ArrayDeque<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			for(int w = 0; w < way.length; w++) {
				int nx = now.x + way[w][0];
				int ny = now.y + way[w][1];
				int nz = now.z + way[w][2];
				if(nx<0 || nx>=L || ny<0 || ny>=R || nz<0 || nz>=C || visited[nx][ny][nz])continue;
				if(box[nx][ny][nz]==BLOCKED)continue;
				if(end.isSame(nx,ny,nz)) {
					return now.time + 1;
				}
				visited[nx][ny][nz] = true;
				queue.add(new Position(nx,ny,nz, now.time+1));
			}
		}
		
		return time;
	}
	static class Position{
		int x, y, z;
		int time;
		Position(int x, int y, int z, int time){
			this.x = x ;
			this.y = y;
			this.z = z;
			this.time = time;
		}
		boolean isSame(int x, int y, int z) {
			if(this.x==x && this.y == y && this.z == z) {
				return true;
			}	
			return false;
		}
	}
}


 