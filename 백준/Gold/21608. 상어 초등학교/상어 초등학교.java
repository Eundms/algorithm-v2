import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { //상어 초등학교
    static int N; // 교실 한변 길이
    static int[][] box;
    static List[] nodes;
    static int[] order;
    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new int[N + 1][N + 1]; // (1,1) ~ (N,N)

        order = new int[N * N + 1]; // order
        nodes = new ArrayList[N * N + 1]; // 노드..
        for (int i = 0; i < N * N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine()); // a -> b
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                nodes[a].add(Integer.parseInt(st.nextToken()));
            }
            order[i] = a;
        }
        box[2][2] = order[0]; // 제일 처음 학생 -> 무조건 2,2

        for (int i = 1; i <= N * N; i++) { // 1 ~ N*N
            List<Integer> currentLike = nodes[order[i]];

            PriorityQueue<Area> areaPQ = new PriorityQueue<>();
            for (int n = 0; n < N; n++) { // 비어있는 칸 중, 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 잡기
                for (int m = 0; m < N; m++) {
                    if (box[n][m] == 0) { // 비어있는 칸
                        int cnt = 0; //(n,m)주변의 좋아하는 사람 수
                        int empty = 0; // (n,m)주변의 empty 수
                        for (int w = 0; w < 4; w++) { // 상하좌우 확인
                            int nx = n + way[w][0];
                            int ny = m + way[w][1];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            for (int l = 0; l < 4; l++) {
                                if (currentLike.get(l) == box[nx][ny]) { // 좋아하는 학생이 근처에 있다면,
                                    cnt += 1;
                                }
                                if (box[nx][ny] == 0) {
                                    empty += 1;
                                }
                            }
                        }
                        areaPQ.add(new Area(n, m, cnt, empty)); // n,m 주변의 좋아하는 사람 수, empty 수
                    }
                }
            }

            // 인접한 칸 중 비어있는 칸이 가장 많은 칸
            // 행의 번호가 가장 작은 칸, 열의 번호가 가장 작은 칸
            Area area = areaPQ.poll();
            box[area.x][area.y] = order[i]; // currentLike current.number;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> near = nodes[box[i][j]];
                int cnt = 0;

                for (int w = 0; w < 4; w++) { // 상하좌우 확인
                    int nx = i + way[w][0];
                    int ny = j + way[w][1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    for (int l = 0; l < 4; l++) {
                        if (near.get(l) == box[nx][ny]) { // 좋아하는 학생이 근처에 있다면,
                            cnt += 1;
                        }
                    }
                }

                if (cnt > 0) {
                    result += Math.pow(10, cnt - 1);
                }
            }
        }

        System.out.println(result);

    }

    static class Area implements Comparable<Area> {
        int x, y, likeCnt, empty;

        public Area(int x, int y, int likeCnt, int empty) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.empty = empty;
        }

        @Override
        public int compareTo(Area o) {
            if (o.likeCnt == this.likeCnt) { // 큰 순서
                if (o.empty == this.empty) { // 큰 순서
                    if (this.x == o.x) { // 작은 순서
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.empty - this.empty;
            }
            return o.likeCnt - this.likeCnt;
        }
    }

    static class Node {
        int number;
        int[] like;

        public Node(int number, int[] like) {
            this.number = number;
            this.like = like;
        }
    }


}
