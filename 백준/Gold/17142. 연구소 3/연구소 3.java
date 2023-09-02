import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M; // 연구소의 크기 // 놓을 수 있는 바이러스의 개수
    static int[][] box;
    static final int EMPTY = 0, WALL = 1, VIRUS = 2;
    static List<int[]> allVirus;
    static int time = Integer.MAX_VALUE;
    static int emptySpace;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 바이러스 M개를 활성 상태로 만든다

        allVirus = new ArrayList<>();
        box = new int[N][N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                box[n][m] = Integer.parseInt(st.nextToken()); // 0 : 빈칸, 1 : 벽, 2 : 비활성 바이러스 위치
                if (box[n][m] == VIRUS) {
                    allVirus.add(new int[]{n, m});
                } else if (box[n][m] == EMPTY) {
                    emptySpace += 1;
                }
            }
        }
        back(0, 0, new int[M]);
        // 바이러스 선택 or 비선택 -> 선택 가능 총 개수 M개
        if(emptySpace == 0){
            System.out.println(0);
            return;
        }
        System.out.println(time == Integer.MAX_VALUE ? -1 : time);

    }

    static int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static void back(int cnt, int start, int[] selected) {//1-?번의 바이러스 중 M개의 바이러스 선택
        if (cnt == M) {
            bfs(emptySpace, selected);
            return;
        }
        for (int i = start; i < allVirus.size(); i++) {
            selected[cnt] = i;
            back(cnt + 1, i + 1, selected);
        }
    }


    static void bfs(int empty, int[] selected) { // 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우 -1 출력
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < selected.length; i++) {
            queue.add(new Pos(allVirus.get(selected[i])[0], allVirus.get(selected[i])[1], 0));
            visited[allVirus.get(selected[i])[0]][allVirus.get(selected[i])[1]] = true;
        }

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int w = 0; w < 4; w++) {
                int nx = now.x + way[w][0];
                int ny = now.y + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || box[nx][ny] == WALL) continue;

                if (box[nx][ny] == EMPTY) {
                    empty -= 1;
                }
                if (empty == 0) {
                    time = Math.min(now.time + 1, time);
                    return;
                }
                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny, now.time + 1));
            }
        }
    }

    static class Pos {
        int x, y;
        int time;

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


}
