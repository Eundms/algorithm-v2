import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int BOX_SIZE, MOVE_CNT;
    static int[][] box;
    static int[][] way = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static Queue<int[]> cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BOX_SIZE = Integer.parseInt(st.nextToken());
        MOVE_CNT = Integer.parseInt(st.nextToken());

        box = new int[BOX_SIZE][BOX_SIZE];
        for (int i = 0; i < BOX_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOX_SIZE; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new ArrayDeque<>();
        cloud.add(new int[]{BOX_SIZE - 1, 1 - 1});
        cloud.add(new int[]{BOX_SIZE - 1, 2 - 1});
        cloud.add(new int[]{BOX_SIZE - 1 - 1, 1 - 1});
        cloud.add(new int[]{BOX_SIZE - 1 - 1, 2 - 1});

        // 모듈러 연산해야 함
        for (int m = 0; m < MOVE_CNT; m++) {
            //System.out.println("<<<<<<<<<<" + (m + 1) + ">>>>>>>>>>");
            //System.out.println("초기상태>>>>>>");
            //printBox(box);

            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 방향
            int s = Integer.parseInt(st.nextToken()); // 이동 칸의 수

            // [1] 모든 구름이 di 방향으로 si칸 이동한다.
            // System.out.println("구름>>>");
            boolean[][] visited = new boolean[BOX_SIZE][BOX_SIZE]; // 구름 방문 여부
            Queue<int[]> incNow = new ArrayDeque<>();
            while (!cloud.isEmpty()) {                // [3] 구름이 모두 사라짐
                int[] now = cloud.poll();
                //System.out.println(now[0] + "," + now[1] + "\t");

                // 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
                int nx = (now[0] + way[d][0] * s) % BOX_SIZE;
                int ny = (now[1] + way[d][1] * s) % BOX_SIZE;

                if (nx < 0) {
                    nx = (nx + BOX_SIZE) % BOX_SIZE;
                }
                if (ny < 0) {
                    ny = (ny + BOX_SIZE) % BOX_SIZE;
                }
                incNow.add(new int[]{nx, ny});
                box[nx][ny] += 1;
                visited[nx][ny] = true;

            }
            //System.out.println("===== 구름에서 비가 내리고 난 후에 =====");
            //printBox(box);

            // [4] incNow에 대해 물복사버그 마법 시전
            int[][] temp = copyBox(box);
            // 대각선 1 3 5 7
            int[] cross = new int[]{1, 3, 5, 7}; // 대각선 방향으로 거리가 1인 칸
            while (!incNow.isEmpty()) {
                int[] now = incNow.poll();

                int cntFillBox = 0;
                for (int wIdx : cross) {
                    int nx = now[0] + way[wIdx][0];
                    int ny = now[1] + way[wIdx][1];
                    if (nx < 0 || nx >= BOX_SIZE || ny < 0 || ny >= BOX_SIZE) {
                        continue;
                    }
                    if (box[nx][ny] > 0) {
                        cntFillBox += 1;
                    }
                }

                temp[now[0]][now[1]] += cntFillBox;
            }

            // [5] 구름 생김
            box = copyBox(temp); // 구름 생김 -> - 2
            //System.out.println("===== 물복사그마법후에 =====");
            //printBox(box);
            for (int i = 0; i < BOX_SIZE; i++) {
                for (int j = 0; j < BOX_SIZE; j++) {
                    if (!visited[i][j] && box[i][j] >= 2) {
                        box[i][j] -= 2;
                        cloud.add(new int[]{i,j});
                    }
                }
            }
            //System.out.println("===== 물(-2)로 줄어든 후에 =====");
            //printBox(box);

        }
        int sum = 0;
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                sum += box[i][j];
            }
        }
        System.out.println(sum);

    }

    private static void printBox(int[][] box) {
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                System.out.print(box[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] copyBox(int[][] origin) {
        int[][] copyed = new int[origin.length][origin[0].length];
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                copyed[i][j] = origin[i][j];
            }
        }
        return copyed;
    }
}
