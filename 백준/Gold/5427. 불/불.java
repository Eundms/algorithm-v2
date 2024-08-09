
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //16637
  static int testCase;
  static char[][] box;
  static char START = '@', WALL = '#', EMPTY = '.', FIRE='*';
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      testCase = Integer.parseInt(br.readLine());
      for (int t = 0; t < testCase; t++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] sangunVisited = new boolean[h][w];

        Queue<int[]> sangun = new ArrayDeque<>();
        Queue<int[]> fires = new ArrayDeque<>();
        box = new char[h][w];
        for (int i = 0; i < h; i++) {
          String line = br.readLine();
          for (int j = 0; j < w; j++) {
            box[i][j] = line.charAt(j);
            if (box[i][j] == START) {
            	sangun.add(new int[] {i, j});
            	sangunVisited[i][j] = true;
            } else if (box[i][j] == FIRE) {
            	fires.add(new int[] {i, j});
            }
          }
        }
        
        // 1) 불 이동 : 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 움직일 수 없음
        // 2) 상근이 이동 
        int[][] way = {{-1,0}, {1,0}, {0,-1}, {0,1}};
       
        boolean isExit = false;
        int exitTime = 1;
        while(true) {
            // 불 이동
            Queue<int[]> newFires = new ArrayDeque<>();
            while(!fires.isEmpty()) {
            	int[] now = fires.poll();
            	
            	for(int wi = 0; wi < 4; wi++) {
            		int nx = now[0] + way[wi][0];
            		int ny = now[1] + way[wi][1];
            		if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
            			continue;
            		}
            		if(box[nx][ny] == WALL || box[nx][ny] == FIRE) {
            			continue;
            		}
            		box[nx][ny] = FIRE;
            		newFires.add(new int[] {nx, ny});
            	}	
            }
            
            // 상근이 이동
            Queue<int[]> nextSangun = new ArrayDeque<>();
            
            while(!sangun.isEmpty()) {
            	int[] now = sangun.poll();
            	
                for (int wi = 0; wi < 4; wi ++) {
                	int nx = now[0] + way[wi][0];
                	int ny = now[1] + way[wi][1];
                	if(nx < 0 || nx >= h || ny < 0 || ny >= w) {isExit = true; break;}
                	if(sangunVisited[nx][ny])continue;
                	if (box[nx][ny] == EMPTY) {
                    	nextSangun.add(new int[] {nx, ny});  
                    	sangunVisited[nx][ny] = true;
                	}
                }
            }
            if(isExit) { // 성공 조건
            	break;
            }
         
            if (nextSangun.isEmpty()) { // 탈출 불가능
            	break;
            }
            
            // 다음 가능한 상근이 위치
            sangun = nextSangun;
            // 다음불
            fires = newFires;
            exitTime++;
        }
        
        if(isExit) {
        	System.out.println(exitTime);
        } else {
        	System.out.println("IMPOSSIBLE");
        }
      }
    }

}