import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // [총 F층 건물] S층 -> G층
    // U D
    static int F, S, G, U, D;
    static int[] way ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 강호 있는 곳
        G = Integer.parseInt(st.nextToken()); // 스타트 링크 위치
        U = Integer.parseInt(st.nextToken()); // +U
        D = Integer.parseInt(st.nextToken()); // -D
        way = new int[]{U, -D};
        int cnt = bfs(S);
        if (cnt == -1) { // 강호 있는 곳
            System.out.println("use the stairs");
        } else {
            System.out.println(cnt);
        }
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[F + 1]; // 1 ~ F
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == G) {
                return now[1];
            }
            for (int w = 0; w < 2; w++) {
                int next = now[0] + way[w];
                if (next < 1 || next > F) {
                    continue;
                }
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(new int[]{next, now[1] + 1});
            }
        }
        return -1;
    }


}
