import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//https://www.acmicpc.net/board/view/58513
    static int N, M;
    static int[][] box;
    // {바다: 0 , 빙산: 1 ~ }
    static int[][] copyed;
    static int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /***
     * 빙산 - 동서남북, 0이 저장된 칸의 개수만큼 줄어들음
     * 각 칸에 저장된 높이는 0보다 더 줄어들지 않음
     * 두 덩어리 이상으로 분리되는 최초의 시간(년)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            copyed = copyMatrix(box); // 한꺼번에 녹는다
            int land = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyed[i][j] > 0) {
                        bfs(i, j);
                        land++;
                    }
                }
            }

            if (land >= 2) {
                System.out.println(year);
                break;
            }
            copyed = copyMatrix(box); // 한꺼번에 녹는다
            for (int i = 0; i < N; i++) { // [1] 1년 단위,
                for (int j = 0; j < M; j++) {
                    if (box[i][j] > 0) {
                        // 상하좌우 탐색하여 0 갯수 세기
                        int cntZero = 0;
                        for (int w = 0; w < 4; w++) {
                            int nx = i + way[w][0];
                            int ny = j + way[w][1];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }
                            if (box[nx][ny] == 0) {
                                cntZero += 1;
                            }
                        }
                        if (copyed[i][j] - cntZero > 0) {
                            copyed[i][j] -= cntZero;
                        } else {
                            copyed[i][j] = 0;
                        }
                    }
                }
            }

            box = copyMatrix(copyed);

            // [2] 덩어리 확인
            // bfs



            if (isAllMelt()) { // 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않음
                System.out.println(0);
                break;
            }
            year++;
        }


    }

    private static boolean isAllMelt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] >= 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        copyed[i][j] = 0;
        while (!queue.isEmpty()){
            int[] next = queue.poll();
            for (int w = 0; w < 4; w++) {
                int nx = next[0] + way[w][0];
                int ny = next[1] + way[w][1];
                if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
                if(copyed[nx][ny]>0){
                    copyed[nx][ny]=0;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

    }
    private static int[][] copyMatrix(int[][] box){
        int[][] temp = new int[N][M];
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                temp[n][m]=box[n][m];
            }
        }
        return temp;
    }
    private static void printMatrix(int[][] box){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
    }
}
