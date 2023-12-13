import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {// 21609 상어 중학교
	static int[][] box;
	static boolean[][] visited;
	static int N,M;
	static int score;
	static int EMPTY = -9;
	static int BLACK = -1;
	static int RAINBOW = 0;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //한변의 크기
        M = Integer.parseInt(st.nextToken()); //색상의 개수
        
        box = new int[N][N];
        for(int i = 0; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N ; j++) {
        		box[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        while(true) {
        	
        	// 가장 큰 블록 그룹을 찾는다 (행 가장 큰거, 열 가장 큰거 -> = 도 포함)
            visited = new boolean[N][N];
            int x = 0, y = 0;
            List<int[]> maxBlockGroup = new ArrayList<>();
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		if(box[i][j]>=1 && box[i][j]<=M && !visited[i][j]) { // 일반 블록 적어도 하나
            			
                		List<int[]> blocks = findBlock(i,j);
                        if(isLeftBigger(blocks,i,j, maxBlockGroup,x,y)) {
                        	maxBlockGroup = blocks;
                        	x = i;
                        	y = j;
                        }        			
            		}
            		
            	}
            }
         
//            printBox();
//            printBlockGroup(maxBlockGroup);
           if(maxBlockGroup.size()==0) { // 오토 플레이는 블록 그룹이 존재하는 동안 계속된다
            	break;
           }  
        
           	
            // 2. 블록 제거 & 점수 B^2점 획득
            delBlock(maxBlockGroup);
            
            score += calculateScore(maxBlockGroup.size());
//            System.out.println(score);
            
            // 3. 중력 작용
            box = weight();
           
            // 4. 반시계 회전
            box = rotateReverse(box);
            
            box = weight();
         
            
        }
        
        System.out.println(score);
    }
	//그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹, 
	//그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 
	// 그것도 여러개이면 열이 가장 큰 것을 찾는다.
	static boolean isLeftBigger(List<int[]>a,int ax, int ay, List<int[]>b,int bx, int by) {
		if(a.size()== b.size()) {
			int aCount = 0;
			for(int i = 0; i < a.size();i++) {
				aCount+= box[a.get(i)[0]][a.get(i)[1]]==RAINBOW?1:0;
			}
			int bCount = 0;
			for(int j = 0; j< b.size(); j++) {
				bCount+= box[b.get(j)[0]][b.get(j)[1]]==RAINBOW?1:0;				
			}
			if(aCount == bCount) {
				if(ax==bx) {
					return ay>by;
				}
				return ax>bx;
			}
			return aCount > bCount;
		}
		return a.size()>b.size();
	}
	static int[][] weight() { // 중력 작용
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ; j++) {
				temp[i][j] = EMPTY;
			}
		}
		for(int j = 0; j < N; j++) {
			int k = N-1; // 행 맨 아래부터 채워서 위로
			for(int i = N-1; i >= 0 ; i--) {
				if(box[i][j]==EMPTY) {continue;}
				if(box[i][j]==BLACK) {
					temp[i][j] = box[i][j];
					k = i-1;
				}else {
					temp[k--][j] = box[i][j];					
				}
			}
		}
		return temp;
	}
	static int[][] rotateReverse(int[][] box) { // 반시계 방향으로 회전
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[N-1-j][i] = box[i][j];
			}
		}
		return temp;
	}
	static int[][] way = {{1,0},{0,-1},{-1,0},{0,1}};
	static List<int[]> findBlock(int si, int sj){ // 크기가 가장 큰 블록 그룹 찾기
		
		boolean[][] copyedVisited = copy(visited);
		int color = box[si][sj];
		
		List<int[]> rainbow = new ArrayList<>();
		List<int[]> current = new ArrayList<>();
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {si,sj});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(copyedVisited[now[0]][now[1]])continue;
			copyedVisited[now[0]][now[1]] = true;
			if(box[now[0]][now[1]]==RAINBOW) {
				rainbow.add(new int[] {now[0],now[1]});
			}
			current.add(new int[] {now[0],now[1]});
			for(int w = 0 ; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				
				if(nx<0|| nx>=N || ny<0 || ny>=N || copyedVisited[nx][ny])continue;
				if(box[nx][ny]==color|| box[nx][ny]==RAINBOW) {
					queue.add(new int[] {nx,ny});					
				}
			}
		}
		if(current.size()>=2) {
			for(int i = 0 ; i < rainbow.size();i++) {
				copyedVisited[rainbow.get(i)[0]][rainbow.get(i)[1]] = false;
			}
			visited = copy(copyedVisited);
			
			return current;
		}
		return new ArrayList<>(); 
	}
	static void delBlock(List<int[]> group) { // 모든 블록 제거
		for(int i = 0; i < group.size(); i++) {
        	int row = group.get(i)[0];
        	int col = group.get(i)[1];
        	box[row][col] = EMPTY;
        }
	}
	static int calculateScore(int x) {
		return x * x;
	}
	
	private static boolean[][] copy(boolean[][] visited){
		boolean[][] copyed = new boolean[N][N];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N ; j++) {
				copyed[i][j] = visited[i][j];
			}
		}
		return copyed;
	}
	private static void printBlockGroup(List<int[]>group) {
		for(int i= 0; i < group.size(); i++) {
			System.out.print(group.get(i)[0]+","+group.get(i)[1]+" ");
		}
		System.out.println();
	}
	private static void printBox() {
		for(int i = 0; i < N; i++) {
			for(int j=0; j < N; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
/*
 * 1. 크기가 가장  큰 블록 그룹을 찾는다
 * 2. 포함된 무지개 블록의 수가 가장 많은 블록 그룹
 * 	1) 기준 블록의 행이 가장 큰 것
 * 	2) 열이 가장 큰 것
 * 3. 모든 블록 제거
 * 4. 중력 작용
 * 5. 반시계 방향으로 회전
 * 6. 중력 작용
 * */

 