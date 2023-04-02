import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] box;
    static int[][] way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int wIdx; //
    static LinkedList<Integer> diceRow; //행
    static LinkedList<Integer> diceCol; //열
    static int diceX = 1, diceY = 1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        K = Integer.parseInt(st.nextToken()); // 이동 횟수
        box = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        initDice();
        wIdx = 0;

        int score = 0;
        for (int k = 0; k < K; k++) { // k번 이동
            rollAndMove(); // 주사위 이동 + 1
            score += getScore();
            decideWay();
        }
        System.out.println(score);
    }

    private static void rollAndMove() {
        int nx = diceX + way[wIdx][0];
        int ny = diceY + way[wIdx][1];
        if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= M + 1) {
            wIdx = (wIdx + 2) % 4;
            nx = diceX + way[wIdx][0];
            ny = diceY + way[wIdx][1];
        }
        moveDice(nx, ny); // 한칸 이동한다.
        rollDice(); // 이동방향으로 굴른다
    }

    private static int getScore() {
        int B = box[diceX][diceY];
        int cnt = bfs(diceX, diceY, B);
        return cnt == 1 ? box[diceX][diceY] : cnt * B;
    }

    private static int bfs(int x, int y, int item) {
        visited = new boolean[N+1][M+1];

        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]][now[1]]) { // 노드 들어온 순간
                continue;
            }
            visited[now[0]][now[1]] = true; // - 방문 처리
            cnt += 1;
            for (int w = 0; w < 4; w++) { // 인접한 노드
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= M + 1|| visited[nx][ny]) {
                    continue;
                }
                if (box[nx][ny] == item) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }


    private static void moveDice(int nx, int ny) {
        diceX = nx;
        diceY = ny;
    }

    private static void rollDice() {

        if (wIdx == 0) { // 오른쪽 방향
            diceRow.addFirst(diceRow.pollLast());
            diceCol.remove(1);
            diceCol.add(1, diceRow.get(1));
            diceCol.remove(3);
            diceCol.add(3, diceRow.get(3));

        } else if (wIdx == 2) { //왼쪽
            diceRow.addLast(diceRow.pollFirst());
            diceCol.remove(1);
            diceCol.add(1, diceRow.get(1));
            diceCol.remove(3);
            diceCol.add(3, diceRow.get(3));
        } else if (wIdx == 1) { // 아래 방향
            diceCol.addFirst(diceCol.pollLast());
            diceRow.remove(1);
            diceRow.add(1, diceCol.get(1));
            diceRow.remove(3);
            diceRow.add(3, diceCol.get(3));
        } else { //
            diceCol.addLast(diceCol.pollFirst());
            diceRow.remove(1);
            diceRow.add(1, diceCol.get(1));
            diceRow.remove(3);
            diceRow.add(3, diceCol.get(3));
        }
    }

    private static void decideWay() {
        int A = diceCol.get(3); // 주사위 아랫면에 있는 정수
        int B = box[diceX][diceY]; // 주사위가 있는 칸에 있는 정수
        if (A > B) {
            wIdx = (wIdx + 1) % 4;
        } else if (A < B) {
            wIdx = (wIdx + 3) % 4;
        }
    }

    private static void initDice() {
        diceRow = new LinkedList<>();
        diceCol = new LinkedList<>();

        diceRow.add(4);
        diceRow.add(1); //
        diceRow.add(3);
        diceRow.add(6); //

        diceCol.add(2);
        diceCol.add(1);
        diceCol.add(5);
        diceCol.add(6);
    }


}
