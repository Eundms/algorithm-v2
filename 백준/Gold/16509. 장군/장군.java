import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int sR, sC; // 상의 위치
    static int eR, eC; // 왕의 위치
    static int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] way2 = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}; // 01 12 23 30


    public static void main(String[] args) throws IOException { // alphabet배열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sR = Integer.parseInt(st.nextToken());
        sC = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        eR = Integer.parseInt(st.nextToken());
        eC = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sR, sC));
    }

    static int bfs(int sR, int sC) {
        // visited[sR][sC]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sR, sC, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
           // System.out.println(now[0] + " " + now[1]);
            if (now[0] == eR && now[1] == eC) {
                return now[2];
            }

            for (int w1 = 0; w1 < 4; w1++) {
                int nx = now[0] + way[w1][0];
                int ny = now[1] + way[w1][1];
                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 9) {
                    continue;
                }

                for (int w2 = 0; w2 < 2; w2++) {
                    int nnx = nx;
                    int nny = ny;
                    boolean canGo = true;
                    for (int i = 0; i < 2; i++) {
                        nnx += way2[(w1 + w2) % 4][0];
                        nny += way2[(w1 + w2) % 4][1];
                        if (nnx < 0 || nnx >= 10 || nny < 0 || nny >= 9 || (i==0 && nnx == eR && nny == eC)) {
                            canGo = false;
                            break;
                        }
                    }
                    if (canGo) {
                        queue.add(new int[]{nnx, nny, now[2] + 1});
                    }
                }
            }

        }

        return -1;
    }


}
