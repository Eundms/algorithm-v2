import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= T; t++) { // 테스트 케이스
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치
            board = new int[M][N];
            for (int k = 0; k < K; k++) {// K줄에 배추의 위치 X,Y가 주어짐
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 배추 심어진 위치 X
                int Y = Integer.parseInt(st.nextToken()); // Y
                board[X][Y] = 1;
            }
            int totalCnt = 0;
            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        totalCnt += dfs(i, j); // 바로 리턴되지 않는 경우 +=1
                    }
                }
            }
            System.out.println(totalCnt);

        }
    }

    static int[][] way = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static int dfs(int i, int j) {
        board[i][j] = 0;
        //System.out.println(i + ", " + j);
        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (board[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
        return 1;
    }
}
