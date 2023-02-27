import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int totalCnt;
    static int MAX_LEN = 100;
    static int[][] box;
    static int blackN; // 검은 스카프의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//검은 스카프의 수

        //for(int test = 1; test<=3;test++) {
        totalCnt=0;
        blackN = Integer.parseInt(br.readLine());

        box = new int[MAX_LEN+2][MAX_LEN+2]; // 양의 정수로 주어짐 즉, 1,1 부터 100,100까지만 주어짐
        StringTokenizer st;
        for(int n=0;n<blackN;n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x; i < Math.min(x+10, MAX_LEN); i++) {
                for(int j= y; j < Math.min(y+10, MAX_LEN); j++) {
                    box[i][j] = 1;
                }
            }
        }
        //printMatrix();
        //System.out.println("===========");
        for(int i=0;i<MAX_LEN+1;i++) {
            for(int j=0;j<MAX_LEN+1;j++) {
                if(box[i][j]==1) {
                    meltBlack(i,j); // 안쪽 둘레에 표시
                }
            }
        }
        System.out.println(totalCnt);


        //}

    }


    private static void meltBlack(int i, int j) {
        boolean visited[][] = new boolean[MAX_LEN+1][MAX_LEN+1];
        Queue<int[]> queue = new ArrayDeque<>(); // 둘레만 넣음
        queue.add(new int[] {i,j});

        while(!queue.isEmpty()) { // 큐가 비어있지 않을 때까지 , 2와 인접한 1을 모두 2로 만든다.
            int[] now = queue.poll();
            for(int w=0;w<4;w++) {
                int nx = now[0]+way[w][0];
                int ny = now[1]+way[w][1];

                if(nx<0 || nx > MAX_LEN || ny<0 || ny>MAX_LEN) {continue;} //범위 상황봐서 바꿔야 함
                if(visited[nx][ny])continue; // 방문한 적이 있으면
                if(box[nx][ny]==0) { //다음으로 갈 곳이 흰색
                    totalCnt+=1;
                    box[now[0]][now[1]] = 2;
                }

                visited[nx][ny] = true; // 방문 처리를 한다.
            }
        }
    }


    static int[][] way = new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; //상하좌우 방향

    private static void printMatrix() { // 디버깅용 함수
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
    }


}