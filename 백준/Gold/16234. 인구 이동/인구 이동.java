import java.io.*;
import java.util.*;

public class Main {
    static int[][] box;
    static int N, L, R;
    static boolean[][] visited;
    static List<int[]> members;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        box = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cntDays = 0;
        while (true) {
            boolean move = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    members = new ArrayList<>();
                    int sum = bfs(i, j);//아직 어떠한 그룹에도 속하지 않음
                    if (members.size() > 1) {
                        movePpl(sum);
                        move = true;
                    }
                }
            }
            if (!move) {
                System.out.println(cntDays);
                return;
            }
            cntDays += 1;
        }
    }

    static void movePpl(int sum) {
        int avg = sum / members.size();
        for(int[] now : members){
            box[now[0]][now[1]] = avg;
        }
    }

    static int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int bfs(int i, int j) { // L명 이상, R명 이하

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{i, j});
        members.add(new int[]{i,j});
        visited[i][j] = true;

        int sumOfUnion = box[i][j];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                int abs = Math.abs(box[now[0]][now[1]] - box[nx][ny]);
                if (abs >= L && abs <= R) {
                    queue.add(new int[]{nx, ny});
                    members.add(new int[]{nx,ny});
                    sumOfUnion += box[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }
        return sumOfUnion;
    }

}
