import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 미세먼지 안녕! ~
    static int R, C, T;
    static int[][] box;
    static List<int[]> air; // 공기 청정기 설치된 곳
    static Queue<int[]> mise;// 미세먼지 양

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken()); // T초 지남

        air = new ArrayList<>();

        box = new int[R][C]; // -1 : 공기청정기
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if (box[r][c] == -1) { // 공기청정기가 설치된 곳
                    if (box[r - 1][c] == -1) {
                        air.add(new int[]{r, c});
                        //System.out.print("r,c "+r+","+c);
                    }
                }
            }
        }


        while (T > 0) {
            mise = new ArrayDeque<>();
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    mise.add(new int[]{r,c});
                }
            }
            // 1. 미세먼지 확산
            // 모든 칸에서 동시에 일어남
            temp = new int[R][C];
            for (int[] item : mise) {
                miseDiffuse(item[0], item[1]);
            }
            box = addMatrix(temp, box);

            // 2. 공기청정기 작동
            for (int[] item : air) {
                airRefresh(item[0], item[1]);
            }
            T--;
        }

        int res=0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(box[r][c]>0){
                    res+=box[r][c];
                }
            }
        }
        System.out.println(res);
    }

    private static int[][] addMatrix(int[][] temp, int[][] box) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                box[r][c] += temp[r][c];
            }
        }
        return box;
    }

    static int[][] temp;

    private static void miseDiffuse(int x, int y) { // 1. 미세먼지 확산 시작점

        int amount = box[x][y] / 5;
        int cnt = 0;
        for (int w = 0; w < 4; w++) {
            int nx = x + clockWay[w][0];
            int ny = y + clockWay[w][1];
            // 미세먼지 (r, c) : 인접한 네 방향으로 확산
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || box[nx][ny] == -1) {// 인접한 방향에 공기청정기가 있다면
                continue;
            }
            // 확산되는 양(amount)은 "A(r,c)/5" 이고 소수점은 버린다.
            temp[nx][ny] += amount;
            cnt++;
        }
        box[x][y] -= amount * cnt;
    }

    static int[][] clockWay = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 시계방향
    static int[][] rClockWay = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 반시계방향

    private static void airRefresh(int x, int y) { // 2. 공기청정기 바람 : 시계방향 순환 -> 아래쪽만 줌..!

        // 위쪽 -> 반시계 ////////////////////////////////////
        int upX = Math.max(0, x - 1);
        int upY = y + 1;
        int rw = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(box[upX][upY]);
        while (true) {
            // 다음 방향 확인
            int nx = upX + rClockWay[rw][0];
            int ny = upY + rClockWay[rw][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                rw += 1;
                continue;
            }
            queue.add(box[nx][ny]);

            upX = nx;
            upY = ny;

            if (upX == Math.max(0, x - 2) && upY == y) {
                break;
            }
        }
        box[Math.max(0, x - 1)][y + 1] = 0;

        upX = Math.max(0, x - 1);
        upY = Math.min(y + 1, C - 1);
        rw = 0;
        while (true) {
            // 다음 방향 확인
            int nx = upX + rClockWay[rw][0];
            int ny = upY + rClockWay[rw][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                rw += 1;
                continue;
            }
            box[nx][ny] = queue.poll();

            upX = nx;
            upY = ny;

            if (upX == Math.max(0, x - 2) && upY == y) {
                break;
            }
        }


        // 아래쪽 -> 시계 ////////////////////////////////////
        int downX = x;
        int downY = y + 1;
        int w = 0;
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.add(box[downX][downY]);
        while (true) {
            // 다음 방향 확인
            int nx = downX + clockWay[w][0];
            int ny = downY + clockWay[w][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                w += 1;
                continue;
            }
            queue2.add(box[nx][ny]);

            downX = nx;
            downY = ny;
            if (downX == x + 1 && downY == y) {
                break;
            }
        }

        box[x][y + 1] = 0;
        downX = x;
        downY = y + 1;
        w = 0;
        while (true) {
            int nx = downX + clockWay[w][0];
            int ny = downY + clockWay[w][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                w += 1;
                continue;
            }
            box[nx][ny] = queue2.poll();
            downX = nx;
            downY = ny;
            if (downX == x + 1 && downY == y) {
                break;
            }
        }

    }

    private static void printMatrix(String str) {
        System.out.println("==================" + str);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (box[i][j] == -1) {
                    System.out.print("X" + "\t");
                } else {
                    System.out.print(box[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
