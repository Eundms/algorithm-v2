import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0}; //위 왼 아래 오
    static int dy[] = {0, 1, 0, -1};
    static PriorityQueue<Node> fishes;
    static Queue<Node> move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        move = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    move.add(new Node(i, j, 0));
                    board[i][j] = 0;
                }
            }
        }

        int exp = 0;
        int time = 0;
        int sharkAge = 2;
        while (true) {
            fishes = new PriorityQueue<>();
            int[][] distance = new int[N][N];

            while (!move.isEmpty()) {
                Node current = move.poll(); // shark가 방문한 위치

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i]; // 다음에 shark가 방문할 위치
                    int ny = current.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && distance[nx][ny] == 0 && board[nx][ny] <= sharkAge) {
                        distance[nx][ny] =
                                distance[current.x][current.y] + 1; // 다음에 shark 방문할 위치까지 움직인 거리 = 지금 위치까지 움직인 거리 + 1
                        move.add(new Node(nx, ny, distance[nx][ny]));  // 다음에 shark 가 방문할 위치
                        if (board[nx][ny] >= 1 && board[nx][ny] <= 6 && board[nx][ny] < sharkAge) {
                            fishes.add(new Node(nx, ny, distance[nx][ny])); // 물고기 위치
                        }
                    }
                }
            }

            if (fishes.size() == 0) { // 물고기가 존재하지 않는다면,
                System.out.println(time);
                return;
            }

            Node currentFish = fishes.poll(); // 잡아먹을 fish 
            time += currentFish.dist; // 현재위치까지 거리
            exp++;
            board[currentFish.x][currentFish.y] = 0;
            if (exp == sharkAge) {
                sharkAge++;
                exp = 0;
            }
            move.add(new Node(currentFish.x, currentFish.y, 0));
        }
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;

            }
            return this.dist - o.dist;
        }
    }
}