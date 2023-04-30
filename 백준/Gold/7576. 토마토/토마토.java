import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N; // 가로 칸의 수, 세로 칸의 수
    // 둘째 줄 ~ N개의 줄 : 상자에 담긴 토마토의 정보
    //1익음 0 익지않음 -1 토마토x
    static int[][] box;
    static Queue<int[]> queue;
    static int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        box = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
                if (box[n][m] == 1) {
                    queue.add(new int[]{n, m});
                }
            }
        }
        if (checkRipe()) {
            System.out.println(0);
        } else if (queue.size() == 0) {
            System.out.println(-1);
        } else {
            while (!queue.isEmpty()) {
                // 익을 때까지 최소 날짜 출력
                int[] now = queue.poll();
                for (int w = 0; w < 4; w++) {
                    int nx = now[0] + way[w][0];
                    int ny = now[1] + way[w][1];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = box[now[0]][now[1]] + 1;
                        result = Math.max(result, box[nx][ny]);
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            if (!checkRipe()) {
                System.out.println(-1);
            }else{
                System.out.println(result - 1);

            }
        }

    }

    static boolean checkRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {//모든 토마토가 익지 못하는 상태
                    return false;
                }
            }
        }
        return true;
    }
}
