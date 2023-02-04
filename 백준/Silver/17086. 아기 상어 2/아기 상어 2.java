import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*주의 : 상어끼리의 거리 최솟값 구하는 것이 아니었음*/
    private static int N;
    private static int M;
    private static int[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {//0빈칸, 1 아기상어
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {// 0빈칸, 1 아기상어
                if (box[i][j] != 1) {
                    int des = bfs(i, j);
                    max = Math.max(des, max);
                }
            }
        }
        System.out.println(max);


    }


    private static int bfs(int x, int y) {
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 0;
            }
        }
        int[][] way = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(x, y, 0));
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Item now = queue.poll();

            for (int w = 0; w < way.length; w++) {
                int nextx = way[w][0] + now.getx();
                int nexty = way[w][1] + now.getY();
                if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
                    if (visited[nextx][nexty] == 1) {
                        continue;
                    }
                    if (box[nextx][nexty] == 1) {
                        return now.getdes()+1;
                    }
                    queue.add(new Item(nextx, nexty, now.getdes() + 1));
                    visited[nextx][nexty] = 1;
                }
            }
        }
        return 0;
    }
}

class Item {
    int x;
    int y;
    int des;

    Item(int x, int y, int des) {
        this.x = x;
        this.y = y;
        this.des = des;
    }

    int getx() {
        return x;
    }

    int getY() {
        return y;

    }

    int getdes() {
        return des;
    }
}
