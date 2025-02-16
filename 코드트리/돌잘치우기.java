import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static int[][] box;
    static List<int[]> rocks, starts;
    static int[] picked;
    static int maxCnt;
    static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rocks = new ArrayList<>();
        box = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    rocks.add(new int[]{i, j});
                }
            }
        }

        starts = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            starts.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1});
        }

        picked = new int[M];
        comb(0, 0);
        System.out.println(maxCnt);
    }

    static void comb(int depth, int start) {
        if (depth == M) {
            simulate();
            return;
        }

        for (int i = start; i < rocks.size(); i++) {
            picked[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    static void simulate() {
        // 바위 제거
        for (int i = 0; i < M; i++) {
            int[] removed = rocks.get(picked[i]);
            box[removed[0]][removed[1]] = 0;
        }

        // BFS 탐색
        int cnt = bfs();

        // 바위 복구
        for (int i = 0; i < M; i++) {
            int[] removed = rocks.get(picked[i]);
            box[removed[0]][removed[1]] = 1;
        }

        maxCnt = Math.max(maxCnt, cnt);
    }

    static int bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        int cnt = K; // 시작점도 이동 가능 영역에 포함

        for (int[] start : starts) {
            queue.add(start);
            visited[start[0]][start[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] d : way) {
                int nx = now[0] + d[0];
                int ny = now[1] + d[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && box[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
