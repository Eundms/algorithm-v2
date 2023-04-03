import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C; // R행 C열
    static char[][] box;
    static char WATER = '*', ROCK = 'X', EMPTY = '.';
    static int endX, endY;
    static Queue<Node> water = new ArrayDeque<>();
    static Queue<Node> dochi = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        box = new char[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                box[r][c] = str.charAt(c);
                if (box[r][c] == 'D') { //비버의 굴
                    endX = r;
                    endY = c;
                } else if (box[r][c] == 'S') { //고슴도치 위치
                    dochi.add(new Node(r, c, 0));
                } else if (box[r][c] == WATER) { // 물이면,
                    water.add(new Node(r, c, 0));
                }
            }
        }

        // 고슴도치 이동
        // 물 확장
        int res = bfs();
        System.out.println(res == -1 ? "KAKTUS" : res);

    }

    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int bfs() {
        boolean[][] visited = new boolean[R][C];


        // dochi
        while (!dochi.isEmpty()) {
            // water
            if (!water.isEmpty()) {
                int waterSize = water.size();

                for (int s = 0; s < waterSize; s++) { // 같은 level 만큼 반복
                    Node node = water.poll();
                    if (node.x == endX && node.y == endY) {
                        continue;
                    }

                    for (int w = 0; w < 4; w++) {
                        int nx = node.x + way[w][0];
                        int ny = node.y + way[w][1];

                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                            continue;
                        }
                        if (box[nx][ny] == ROCK || box[nx][ny] == WATER || box[nx][ny] == 'D') { // 벽, 물, 비버
                            continue;
                        }
                        //System.out.println("WATER: "+nx+","+ny);
                        box[nx][ny] = WATER;
                        water.add(new Node(nx, ny, node.time + 1));
                    }
                }
            }

            //printMap(box);

            int size = dochi.size(); // 같은 level
            for (int s = 0; s < size; s++) { // 같은 level 만큼 반복
                Node node = dochi.poll();
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;

                if (node.x == endX && node.y == endY) {
                    return node.time;
                }
                for (int w = 0; w < 4; w++) {
                    int nx = node.x + way[w][0];
                    int ny = node.y + way[w][1];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                        continue;
                    }
                    if (box[nx][ny] == EMPTY || box[nx][ny] == 'D') { // .이나 비버 굴이어야 이동이 가능하다
                        dochi.add(new Node(nx, ny, node.time + 1));
                    }

                }
            }


        }
        return -1;
    }

    private static void printMap(char[][] box) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
