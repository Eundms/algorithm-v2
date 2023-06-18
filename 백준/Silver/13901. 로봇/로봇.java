import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int K;
    static int[][] box;
    static int[][] way;

    public static void main(String[] args) throws IOException { // alphabet배열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 방의 크기
        C = Integer.parseInt(st.nextToken());
        box = new int[R][C];
        K = Integer.parseInt(br.readLine());// 장애물의 개수 K

        for (int k = 0; k < K; k++) {
            // 장애물 위치 br, bc
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            box[x][y] = -1;
        }
        st = new StringTokenizer(br.readLine());
        int rX = Integer.parseInt(st.nextToken()); // 로봇 위치
        int rY = Integer.parseInt(st.nextToken());

        way = new int[4][2];
        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < 4; w++) {
            int item = Integer.parseInt(st.nextToken());
            if (item == 1) {//위방향
                way[w][0] = -1;
                way[w][1] = 0;
            } else if (item == 2) {// 아래 방향
                way[w][0] = 1;
                way[w][1] = 0;
            } else if (item == 3) {// 왼쪽 방향
                way[w][0] = 0;
                way[w][1] = -1;
            } else {// 오른쪽 방향
                way[w][0] = 0;
                way[w][1] = 1;
            }
        }
        boolean[][] visited = new boolean[R][C];
        visited[rX][rY] = true;
        int w = 0;
        while (true) {
            int nx = rX + way[w][0];
            int ny = rY + way[w][1];
            int cnt = 0;
            while (cnt < 4) {
                nx = rX + way[w][0];
                ny = rY + way[w][1];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && box[nx][ny] != -1 && !visited[nx][ny]) {
                    break;
                }
                cnt += 1;
                w = (w + 1) % 4;
            }
            if (cnt >= 4) {
                break;
            }
            visited[nx][ny] = true;
            rX = nx;
            rY = ny;
        }
        System.out.println(rX+" "+rY);
    }


}
