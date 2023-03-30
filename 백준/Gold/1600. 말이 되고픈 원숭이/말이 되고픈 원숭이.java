import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // @@@@@@@@@@@@@ 말이 되고픈 원숭이 @@@@@@@@@@@@@
    static int K; // 말처럼 이동 가능한 횟수
    static int W, H; // 가로길이, 세로길이
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W]; // 세로, 가로
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                board[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }

    static Queue<Node> queue;
    static boolean[][][] visited;

    private static int bfs(int i, int j) {
        // visited[x][y][k] :  말처럼 이동한 횟수가 k번일 때, (x,y) 방문 여부
        visited = new boolean[H][W][K + 1];
        queue = new ArrayDeque<>();
        queue.offer(new Node(i, j, 0, 0));
        visited[i][j][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //System.out.println(node.x + " "+node.y);
            if (node.x == H - 1 && node.y == W - 1) {
                return node.depth;
            }
            if (node.k < K) { // K
                jump(node); //점프
            }
            walk(node); // 점프 안하고 걸을 수 있음
        }
        return -1;
    }

    static int[][] wWay = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1} // 인접 네방향 움직이기
    };

    private static void walk(Node node) {
        for (int w = 0; w < 4; w++) {
            int nx = node.x + wWay[w][0];
            int ny = node.y + wWay[w][1];
            int nDepth = node.depth + 1;
            int nk = node.k; // 지금까지 움직인 횟수 유지, 왜? walk 이므로
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                continue;
            }
            if (nk > K || visited[nx][ny][nk] || board[nx][ny] == 1) {
                continue;
            }
            queue.offer(new Node(nx, ny, nDepth, nk)); // 평소대로 움직이므로 nk를 그대로!!
            visited[nx][ny][nk] = true;
        }
    }

    static int[][] jWay = new int[][]{
            {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, // 말의 움직임으로 한 번 움직이기 (K번)
    };

    private static void jump(Node node) {
        for (int w = 0; w < 8; w++) {
            int nx = node.x + jWay[w][0];
            int ny = node.y + jWay[w][1];
            int nDepth = node.depth + 1;
            int nk = node.k + 1; // 지금까지 움직인 횟수 + 1, 왜? jump이므로
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                continue;
            }
            if (nk > K || visited[nx][ny][nk] || board[nx][ny] == 1) {
                continue;
            }
            queue.offer(new Node(nx, ny, nDepth, nk));
            visited[nx][ny][nk] = true;
        }
    }

    static class Node {
        int x, y, depth, k;

        Node(int x, int y, int depth, int k) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.k = k;
        }
    }
}
