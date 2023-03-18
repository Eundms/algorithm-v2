import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // N,M (0,0) ~ (N-1,M-1)
    // 1. 현재칸 청소
    // 2.1. 4칸 중 청소되지 않은 빈칸이 없는 경우,
    // 방향 유지 + 한 칸 후진 + 1번
    // 2.2. 청소되지 않은 빈칸이 있는 경우
    // 반시계 방향 회전 + 한 칸 전진
    static int N, M;
    static int[][] box;
    static Robot robot;
    static int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 반시계 방향 북 동 남 서
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int CLEAN = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 방의 크기
        M = Integer.parseInt(st.nextToken());

        // 로봇 청소기가 있는 좌표 (r,c)
        // 로봇 청소기가 바라보는 방향 d (0: 북, 1: 동, 2: 남, 3: 서)
        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        box = new int[N][M]; // 방
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true){
            // (i,j)
            if (box[robot.r][robot.c] == EMPTY) { // 현재 칸이 청소되지 않음 -> 현재 칸 청소
                box[robot.r][robot.c] = CLEAN;
                cnt +=1;
            }
            boolean cleanNear = false;
            for (int w = 0; w < 4; w++) {
                int nx = robot.r + way[w][0];
                int ny = robot.c + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (box[nx][ny] == EMPTY) { // 청소되지 않은 빈칸이 있는 경우
                    cleanNear = true;
                }
            }
            if (cleanNear == false) { // 현재 칸의 주변 4칸 중, 청소되지 않은 빈칸이 없는 경우

                if (isReversePossible(robot.r, robot.c)) { // 방향을 유지한 채로 한 칸 후진
                    robot.r -= way[robot.d][0];
                    robot.c -= way[robot.d][1];
                } else { // 후진 불가
                    break;
                }
            } else { // 청소되지 않은 빈 칸이 있는 경우
                robot.d = (robot.d + 3) % 4; // 반시계 방향으로 90도 회전

                int nx = robot.r + way[robot.d][0]; // 앞쪽 칸이 청소되지 않은 빈칸 -> 한 칸 전진
                int ny = robot.c + way[robot.d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || box[nx][ny] == WALL ) {
                    continue;
                }
                if(box[nx][ny] == EMPTY) {
                    robot.r = nx;
                    robot.c = ny;
                }
            }
        }
        System.out.println(cnt);



    }

    private static boolean isReversePossible(int r, int c) {
        // d 반대 북(-1,0) - 남(1,0) 동(0,1) - 서(0,-1)
        int dx = -1 * way[robot.d][0];
        int dy = -1 * way[robot.d][1];

        int nx = r + dx;
        int ny = c + dy;
        if (nx < 0 || nx >= N || ny < 0 || ny >= M || box[nx][ny] == WALL ) {
            return false;
        }
        return true;
    }

    static class Robot {
        int r, c, d;

        // d {0:북, 1:동, 2:남, 3:서}
        public Robot(int r, int c, int d) { // 로봇 청소기가 있는 칸의 좌표 (r,c), 바라보는 방향 d
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
