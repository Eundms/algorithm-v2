import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { //감시

    /**
     * 0 : 빈칸      6 : 벽
     * CCTV 방향 -> 사각 지대의 최소 크기
     */
    static int N, M;
    static char[][] box;
    static char[][] temp;

    static List<Loc> cctv; // 0 1 2 3 4 5
    static int dark;
    static int[] cctvNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        cctv = new LinkedList<>();
        box = new char[N][M]; // N x M 크기의 직사각형
        temp = new char[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                temp[n][m] = box[n][m] = st.nextToken().charAt(0);

                if (box[n][m] >= '1' && box[n][m] <= '5') {
                    cctv.add(new Loc(n, m, box[n][m])); //cctv 번호 별 위치 추가
                }
            }
        }

        cctvNum = new int[cctv.size()];
        // 1~5번 cctv 설정
        dark = N * M; //4 ! 중복 순열
        perm(0);


        System.out.println(dark);
    }

    static void perm(int cnt) {
        if (cnt == cctv.size()) {
            for (int c=0;c<cctv.size();c++ ) { //모든  cctv에 대해서
                Loc loc = cctv.get(c);
                int a = cctvNum[c];
                if (loc.cctv == '1') {//1
                    int[] oneDirection = dOne[a];
                    makeDark(loc, oneDirection);//temp를 어둡게 만듦
                } else if (loc.cctv == '2') {//2
                    int[][] twoDirection = dTwo[a%2];
                    for (int i = 0; i < twoDirection.length; i++) {
                        makeDark(loc, twoDirection[i]);
                    }
                } else if (loc.cctv == '3') {//3
                    int[][] threeDirection = dThree[a];

                    for (int i = 0; i < threeDirection.length; i++) {
                        makeDark(loc, threeDirection[i]);
                    }
                } else if (loc.cctv == '4') {//4
                    int[][] fourDirection = dFour[a];
                    for (int i = 0; i < fourDirection.length; i++) {
                        makeDark(loc, fourDirection[i]);
                    }
                } else if (loc.cctv == '5') {
                    int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    for (int i = 0; i < 4; i++) {
                        makeDark(loc, way[i]);
                    }
                }
            }
            dark = Math.min(dark,countDark(temp));
            temp = copy(box);

            return;
        }
        for (int i = 0; i < 4; i++) {//direction Max
            cctvNum[cnt] = i;
            perm(cnt + 1);
        }
    }

    static int[][] dOne = new int[][]{ //4
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int[][][] dTwo = new int[][][]{//2
            {{0, -1}, {0, 1}},
            {{1, 0}, {-1, 0}}};
    static int[][][] dThree = new int[][][]{//4
            {{-1, 0}, {0, 1}},
            {{0, 1}, {1, 0}},
            {{1, 0}, {0, -1}},
            {{-1, 0}, {0, -1}}};
    static int[][][] dFour = new int[][][]{//4
            {{0, -1}, {-1, 0}, {0, 1}},
            {{0, -1}, {1, 0}, {-1, 0}},
            {{0, 1}, {1, 0}, {-1, 0}},
            {{0, 1}, {0, -1}, {1, 0}}
    };


    /**
     * [ CCTV 번호 : 방향 ]
     * 1 : [(0,1)] [(0,-1)] [(1,0)] [(-1,0)] : 4방향
     * 2 : [(0,-1) (0,1)] [(1,0) (-1,0)] : 2방향
     * 3 : [(-1,0) (0,1)] [(0,1) (1,0)] [(1,0), (0,-1)] [(-1,0), (0,-1)]: 4방향
     * 4 : [(0,-1) (-1,0) (0,1)]    : 4방향
     * 5 : [(0,-1) (-1,0) (0,1) (1,0)] : 의미없음
     */

    private static void makeDark(Loc loc, int[] way) {
        int i = loc.x, j = loc.y;
        while (true) {
            int nextX = i + way[0];
            int nextY = j + way[1];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) break;
            if (temp[nextX][nextY] == '6') {
                break;
            }
            temp[nextX][nextY] = '#';
            i = nextX;
            j = nextY;
        }

    }


    static int countDark(char[][] area) {
        int darkArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == '0') {
                    darkArea++;
                }
            }
        }
        return darkArea;
    }

    static char[][] copy(char[][] origin) {
        char[][] temp = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = origin[i][j];
            }
        }
        return temp;
    }

    static class Loc {
        int x, y;
        char cctv; //cctv번호

        public Loc(int x, int y, char cctv) {
            this.x = x;
            this.y = y;
            this.cctv = cctv;
        }
    }

    static void printMatrix(char[][] temp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


