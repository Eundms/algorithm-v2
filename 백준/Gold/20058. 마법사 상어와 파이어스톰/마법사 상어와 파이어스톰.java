import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
	static int N,Q;
    static int[][] A;
    static int boxLen;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 2^N
        Q = Integer.parseInt(st.nextToken()); // 반복 횟수
        boxLen = (int) Math.pow(2,N);
        A = new int[boxLen][boxLen];
        for(int i = 0; i < boxLen; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < boxLen; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        st = new StringTokenizer(br.readLine());
        // 얼음이 3개 이상 인접해있지 않으면, 얼음양 -1
        for(int q = 1; q <= Q; q++) {
        	int level = Integer.parseInt(st.nextToken());
        	rotate(level);
        	minusIce();
        }

        int sumIce = 0;
        int maxSizeOfIces = 0;
        for(int i = 0; i < boxLen; i++) {
        	for(int j = 0 ; j < boxLen; j++) {
        		if(A[i][j]>0) {
            		sumIce+=A[i][j];        			
        		}
        	}
        }
        System.out.println(sumIce);
        visited = new boolean[boxLen][boxLen];
        for(int i = 0; i < boxLen; i++) {
        	for(int j = 0; j < boxLen; j++) {
        		if(A[i][j]>0 && !visited[i][j]) {
            		maxSizeOfIces = Math.max(maxSizeOfIces,findMaxGroup(i,j));        			
        		}
        	}
        }
        System.out.println(maxSizeOfIces);
    }
	
	static void printBox(int[][] box) {
		for(int i = 0; i < boxLen; i++) {
			for(int j = 0; j < boxLen; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean[][] visited;
	static void minusIce() {
		int[][] after = new int[boxLen][boxLen];
		
		for(int i = 0; i < boxLen; i++) {
			for(int j = 0; j < boxLen; j++) {
				int cnt = 0;
				for(int w = 0; w < 4; w++) {
					int nx = i + way[w][0];
					int ny = j + way[w][1];
					if(nx<0 || nx>=boxLen || ny<0 || ny>=boxLen) {continue;}
					if(A[nx][ny]>0) {cnt+=1;}
				}
				if(cnt<3) {after[i][j] = A[i][j] - 1;}
				else {after[i][j] = A[i][j];}
			}
		}
		A = copyBox(after);
	}
	static int[][] way = {{-1,0},{0,1},{1,0},{0,-1}};
	static int melt(int sx, int sy) {
		
		return 1;
	}
	
	static void rotate(int level) {
		int miniBoxSize = (int)Math.pow(2, level);
		for(int i = 0; i < boxLen; i+=miniBoxSize) {
			for(int j = 0; j < boxLen; j+=miniBoxSize) {
				int[][] box = new int[miniBoxSize][miniBoxSize];
				
				for(int row = i; row < i + miniBoxSize; row++) {
					for(int col = j ; col < j + miniBoxSize; col++) {
						int x = row-i;
						int y = col-j;
						box[y][miniBoxSize-1-x] = A[row][col];
					}
				}
				for(int row = i; row < i + miniBoxSize; row++) {
					for(int col = j ; col < j + miniBoxSize; col++) {
						int x = row-i;
						int y = col-j;
						A[row][col] = box[x][y];
					}
				}
			}
		}
	}

	static int findMaxGroup(int i , int j) {
		int size = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(visited[now[0]][now[1]])continue;
			visited[now[0]][now[1]] = true;
			size+=1;
			for(int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if(nx<0 || nx>=boxLen || ny<0 || ny>=boxLen || visited[nx][ny] || A[nx][ny]<=0)continue;
				
				queue.add(new int[] {nx,ny});
			}
		}
		
		return size;
	}

	static int[][] copyBox(int[][] prev){
		int[][] temp = new int[boxLen][boxLen];
		for(int i = 0 ; i < boxLen ; i++) {
			for(int j = 0; j < boxLen ; j++) {
				temp[i][j] = prev[i][j];
			}
		}
		return temp;
	}
	
}