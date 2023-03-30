import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M; // 세로 x 가로
    static int[][] box;
    static int[][] copyed;
    static Queue<int[]> virusLoc; // 바이러스 위치
    static List<int[]> emptyLoc; // 바이러스 옆 위치
    static int[] walls; // 벽 세울 위치
    static List<int[]> originalVirusLoc;
    static final int EMPTY = 0, WALL = 1, VIRUS = 2;
    static int[][] way = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int maxSafeCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N][M]; // 직사각형
        emptyLoc = new ArrayList<>();
        virusLoc = new ArrayDeque<>();
        originalVirusLoc = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
                if (box[n][m] == VIRUS) { // 바이러스 2
                    originalVirusLoc.add(new int[]{n,m}); // 바이러스 위치
                }
                if(box[n][m]==EMPTY){
                    emptyLoc.add(new int[]{n, m});
                }
            }
        }

        // 초기 바이러스(nVirus) 옆 칸 3개 선택 ncr
        walls = new int[3];
        comb(0, 0);
        System.out.print(maxSafeCnt);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            copyed = copyMatrix(box); // 복사한 matrix

            for (int i = 0; i < 3; i++) {
                int[] loc = emptyLoc.get(walls[i]);
                copyed[loc[0]][loc[1]] = WALL;
            }
            copyVirus();
            bfs();
            maxSafeCnt = Math.max(maxSafeCnt, countSafeArea(copyed));
            return;
        }
        for (int i = start; i < emptyLoc.size(); i++) {
            walls[cnt] = i; 
            comb(cnt + 1, i + 1);
        }
    }

    private static int countSafeArea(int[][] copyed) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyed[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][M];
        while (!virusLoc.isEmpty()) {
            int[] loc = virusLoc.poll(); // 바이러스 위치
            for (int w = 0; w < 4; w++) { // 방향 변화
                int nx = loc[0] + way[w][0];
                int ny = loc[1] + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) continue;
                if (copyed[nx][ny] == EMPTY) {
                    visited[nx][ny] = true;
                    copyed[nx][ny] = VIRUS;
                    virusLoc.offer(new int[]{nx, ny}); // 바이러스 다음 위치
                }
            }
        }
    }

    private static void copyVirus() { // 바이러스 복사
        virusLoc = new ArrayDeque<>();
        for (int i = 0; i < originalVirusLoc.size(); i++) {
            virusLoc.add(originalVirusLoc.get(i));
        }

    }

    private static int[][] copyMatrix(int[][] box) {
        int[][] temp = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                temp[n][m] = box[n][m];
            }
        }
        return temp;
    }

    private static void printMatrix(int[][] copyed){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(copyed[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
