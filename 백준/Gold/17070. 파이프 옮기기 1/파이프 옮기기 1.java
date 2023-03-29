import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {// 파이프 옮기기1
    static int N; // 집의 크기
    static int[][] box; // 그래프 상태

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new int[N][N];

        StringTokenizer st;
        for (int w = 0; w < N; w++) { // 가로길이
            st = new StringTokenizer(br.readLine());
            for (int h = 0; h < N; h++) { // 세로길이
                box[w][h] = Integer.parseInt(st.nextToken());
            }
        }


        // 제한사항 :
        // 0) 제일 처음 파이프 고정,
        // 1) 45도 : (w+1)%3 만 확인
        // 2) 벽있는 경우 : 45도 돌렸을 때 벽이 있는지 확인
        // baseCase : dp[0][1] = 1
        visited = new boolean[N][N];
        visited[0][1] = true;
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    static int cnt = 0;
    static boolean[][] visited;
    static int[][] way = new int[][]{{0, 1}, {1, 1}, {1, 0}}; // 끝이 위치할 수 있는 3가지 방향

    private static void dfs(int i, int j, int wIdx) {
        if (i == N - 1 && j == N - 1) {
            cnt += 1;
            return;
        }

        if (wIdx == 0) {// ->
            for (int w = 0; w < 2; w++) {
                int ni = i + way[w][0];
                int nj = j + way[w][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    continue;
                }
                if (box[ni][nj] == 1) {
                    continue;
                }
                if (w == 1 && (box[ni - 1][nj] == 1 || box[ni][nj - 1] == 1)) {//대각선인 경우
                    continue;
                }
                dfs(ni, nj, w);
            }
        } else if (wIdx == 1) { // 오른쪽아래
            for (int w = 0; w < 3; w++) {
                int ni = i + way[w][0];
                int nj = j + way[w][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    continue;
                }
                if (box[ni][nj] == 1) {
                    continue;
                }
                if (w == 1 && (box[ni - 1][nj] == 1 || box[ni][nj - 1] == 1)) {//대각선인 경우
                    continue;
                }
                dfs(ni, nj, w);
            }
        } else if (wIdx == 2) { // 아래
            for (int w = 1; w < 3; w++) {
                int ni = i + way[w][0];
                int nj = j + way[w][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    continue;
                }
                if (box[ni][nj] == 1) {
                    continue;
                }
                if (w == 1 && (box[ni - 1][nj] == 1 || box[ni][nj - 1] == 1)) {//대각선인 경우
                    continue;
                }
                dfs(ni, nj, w);
            }
        }
    }


}
