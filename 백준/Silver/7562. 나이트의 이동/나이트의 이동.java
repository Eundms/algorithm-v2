import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        for (int test = 1; test <= T; test++) {
            l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            // 체스판의 크기 l * l - 한 변의 길이
            //int[][] box = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            System.out.println(bfs(start, end));
        }

    }

    private static int bfs(int[] start, int[] end) {
        int x = start[0];
        int y = start[1];

        int[][] way = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        boolean[][] visited = new boolean[l][l];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;
            if (now[0] == end[0] && now[1] == end[1]) {
                return now[2];
            }
            for (int w = 0; w < 8; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                    continue;
                }
                queue.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        return 0;
    }


}
