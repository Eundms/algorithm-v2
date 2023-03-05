import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H; // 상자크기 N x M , 상자의 수 H
    static int[][][] box;
    static int dayCnt;
    static Queue<int[]> queue;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
        H = Integer.parseInt(st.nextToken()); // 쌓아 올려지는 상자의 수

        queue = new ArrayDeque<>();
        visited = new boolean[N][M][H];
        box = new int[N][M][H];
        boolean isAlreadyRipped = true;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[n][m][h] = Integer.parseInt(st.nextToken());
                    if (box[n][m][h] == 0) { // 익지 않은 토마토
                        isAlreadyRipped = false;
                    } else if (box[n][m][h] == 1) { // 익은 토마토
                        queue.add(new int[]{n, m, h, 0});
                        visited[n][m][h] = true;
                    }
                }
            }
        }

        if (isAlreadyRipped) { // 이미 모두 익어있는 상황
            System.out.println(0);
        } else { //
            int dayCnt = bfs();
            if (checkIsAllRipped()) {
                System.out.println(dayCnt);
            } else {
                System.out.println(-1);
            }

        }

        // 최소 며칠이 걸리는지 계산해서 출력해야 한다.
    }

    private static boolean checkIsAllRipped() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[n][m][h] == 0) { // 익지 않은 토마토
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int[][] way = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    private static int bfs() {

        int time = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            time = Math.max(now[3], time);
            for (int w = 0; w < 6; w++) {
                int nextN = now[0] + way[w][0];
                int nextM = now[1] + way[w][1];
                int nextH = now[2] + way[w][2];
                int nextT = now[3] + 1;
                if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M || nextH < 0 || nextH >= H) {
                    continue;
                }
                if (visited[nextN][nextM][nextH] || box[nextN][nextM][nextH] == 1
                        || box[nextN][nextM][nextH] == -1) { // 방문
                    continue;
                }
                visited[nextN][nextM][nextH] = true;
                box[nextN][nextM][nextH] = 1;
                queue.add(new int[]{nextN, nextM, nextH, nextT});
            }
        }
        return time;
    }


    private static void printBoxs() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    System.out.print(box[n][m][h] + " ");
                }
                System.out.println();
            }
            System.out.println("===========");
        }
    }
}
