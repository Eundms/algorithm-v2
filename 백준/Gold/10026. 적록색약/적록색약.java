import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { // 적록색약
    static int N; // 첫째 줄
    static char[][] box;// N개 줄에는 그림이 주어짐
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                box[i][j] = str.charAt(j);
            }
        }
        int allColor = 0;
        visited = new boolean[N][N];
        // 적록 색약이 아닌 사람은  [B]  [R] [G]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //System.out.println("START >>"+i+", "+j);
                if (box[i][j] == 'B') {
                    allColor += dfs(i, j, 'B');
                } else if (box[i][j] == 'R') {
                    allColor += dfs(i, j, 'R');
                } else {
                    allColor += dfs(i, j, 'G');
                }
                //System.out.println("                               "+allColor);
            }
        }

        //System.out.println("\n\n\n");
        int lessColor = 0;
        visited = new boolean[N][N];
        // 적록 색약은  [B] [R G]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 'B') {
                    lessColor += dfs(i, j, 'B');
                } else {
                    lessColor += dfs(i, j, 'R', 'G');
                }

            }
        }
        System.out.println(allColor + " " + lessColor);

    }

    static int[][] way = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int dfs(int i, int j, char... color) {
        if (visited[i][j]) return 0;
        visited[i][j] = true; //현재노드 방문처리
        //System.out.println("(i,j): "+i+","+j+"  color: "+ Arrays.toString(color));
        //printMatrix();
        for (int w = 0; w < 4; w++) {
            int nextX = i + way[w][0];
            int nextY = j + way[w][1];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

            if (!(box[nextX][nextY] == color[0] || color.length == 2 && box[nextX][nextY] == color[1])) continue;
            dfs(nextX, nextY, color);
        }
        return 1 ;
    }
    private static void printMatrix(){
        for(int i=0;i<N;i++){
            for(int j = 0; j<N;j++){
                if(visited[i][j]){
                    System.out.print("X ");
                }else{
                    System.out.print(box[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
