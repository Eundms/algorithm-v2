import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[][] way = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int N, M, K; // N x N 격자, 파이어볼 M개, K번
    static List<FireBall>[][] box;

    // (r_i, c_i) 질량 m_i 속력 s_i 방향 d_i
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 크기 N x N 격자
        M = Integer.parseInt(st.nextToken()); // 파이어볼 M개
        K = Integer.parseInt(st.nextToken()); // 이동 K번

        box = init();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 방향
            box[r][c].add(new FireBall(w, s, d));
        }

        for (int k = 0; k < K; k++) { // k번 명령 -> 남아있는 파이어볼 질량의 합?
            // 1. 방향 d, 속력 s 이동
            //System.out.println("[이동전]");
            //print(box);

            List<FireBall>[][] temp = init();

            for (int i = 0; i < N; i++) {  // [1] Move Shark
                for (int j = 0; j < N; j++) {
                    List<FireBall> ijFireBalls = box[i][j];

                    for (int f = 0; f < ijFireBalls.size(); f++) {
                        int nx = (i + box[i][j].get(f).s * way[box[i][j].get(f).d][0]) % N; // 속력 * 방향
                        int ny = (j + box[i][j].get(f).s * way[box[i][j].get(f).d][1]) % N;
                        if (nx <= 0) {
                            nx = (N + nx) % N;
                        }
                        if (ny <= 0) {
                            ny = (N + ny) % N;
                        }
                        temp[nx][ny].add(
                                new FireBall(ijFireBalls.get(f).w, ijFireBalls.get(f).s, ijFireBalls.get(f).d));
                    }
                }
            }

            //System.out.println("[이동후]");
            //print(temp);

            List<FireBall>[][] temp2 = init();

            for (int i = 0; i < N; i++) { // [2] After Move
                for (int j = 0; j < N; j++) {

                    if (temp[i][j].size() >= 2) { // 2개 이상의 파이어볼
                        int sumW = 0, sumS = 0;
                        boolean isAllSame = true, isAllEven = false, isAllOdd = false;
                        if (temp[i][j].get(0).d % 2 == 0) {
                            isAllEven = true;
                        } else {
                            isAllOdd = true;
                        }

                        for (int f = 0; f < temp[i][j].size(); f++) {
                            sumW += temp[i][j].get(f).w;
                            sumS += temp[i][j].get(f).s;
                            if (isAllOdd && temp[i][j].get(f).d % 2 == 0
                                    || isAllEven && temp[i][j].get(f).d % 2 != 0) {
                                isAllSame = false;
                            }
                        }

                        // (4) 질량 0 -> 없어짐
                        int newW = sumW / 5; // (1) 질량의합/5
                        int newS = sumS / temp[i][j].size(); // (2) 속력의합/파이볼개수

                        //System.out.println("( 새로운 질량, 속력 ) : " + newW + ", " + newS);
                        if (newW > 0) {
                            if (isAllSame) {
                                int[] fourWay = {0, 2, 4, 6};
                                for (int w = 0; w < 4; w++) {
                                    temp2[i][j].add(new FireBall(newW, newS, fourWay[w]));
                                }
                            } else {
                                int[] fourWay = {1, 3, 5, 7};
                                for (int w = 0; w < 4; w++) {
                                    temp2[i][j].add(new FireBall(newW, newS, fourWay[w]));
                                }
                            }
                        }
                    } // 2개미만의 파이어볼
                    else {
                        temp2[i][j] = temp[i][j];
                    }

                }
            }

            //System.out.println("[합쳐지고 4개로 나눠짐]");
            //print(temp2);

            box = temp2;
            //System.out.println("----------------------");
        }

        int sumWeight = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<FireBall> temp = box[i][j];
                for (int cnt = 0; cnt < temp.size(); cnt++) {
                    sumWeight += temp.get(cnt).w;
                }
            }
        }
        System.out.println(sumWeight);

    }

    private static void print(List<FireBall>[][] temp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<FireBall> fireballs = temp[i][j];
                if (fireballs.size() > 0) {
                    System.out.print("[" + i + ", " + j + "]\t:\t");
                    for (int c = 0; c < fireballs.size(); c++) {
                        System.out.print(fireballs.get(c) + "\t");
                    }
                    System.out.println();
                }

            }
        }
    }

    static class FireBall {
        int w, s, d; // 질량, 속력, 방향

        public FireBall(int w, int s, int d) {
            this.w = w; // 질량
            this.s = s; // 속력
            this.d = d; // 방향
        }

        @Override
        public String toString() {
            return "FireBall{" +
                    "w=" + w +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    private static List<FireBall>[][] init() {
        List<FireBall>[][] box = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = new ArrayList<>();
            }
        }
        return box;
    }
}
