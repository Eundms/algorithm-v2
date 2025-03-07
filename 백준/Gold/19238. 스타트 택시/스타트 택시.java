import java.io.*;
import java.util.*;

public class Main {
    static int N, M, fuel;
    static int[][] box;
    static int[][] personToId;
    static int[] car;
    static int[][] routes;
    static final int INF = Integer.MAX_VALUE;
    static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        box = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        car = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        personToId = new int[N][N];
        routes = new int[M + 1][5];

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            routes[m] = new int[]{sx, sy, ex, ey, bfs(sx, sy, ex, ey)};
            personToId[sx][sy] = m;
        }

        while (true) {
            int[] person = findNear();
            if (person[0] == -1 || routes[person[0]][4] == INF || fuel < person[1]) break;
            
            fuel -= person[1];
            car[0] = routes[person[0]][0];
            car[1] = routes[person[0]][1];

            if (fuel < routes[person[0]][4]) break;
            
            fuel += routes[person[0]][4];
            car[0] = routes[person[0]][2];
            car[1] = routes[person[0]][3];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (personToId[i][j] > 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(fuel);
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == ex && now[1] == ey) return now[2];
            
            for (int[] dir : way) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || box[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        return INF;
    }

    static int[] findNear() {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.add(new int[]{car[0], car[1], 0});
        visited[car[0]][car[1]] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (personToId[now[0]][now[1]] > 0) {
                int id = personToId[now[0]][now[1]];
                personToId[now[0]][now[1]] = -1;
                return new int[]{id, now[2]};
            }
            
            for (int[] dir : way) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || box[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                pq.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        return new int[]{-1, INF};
    }
}
