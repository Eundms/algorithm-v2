import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 제한 사항
     * min(N,M) mod 2 = 0
     * <p>
     * 따라서, 아래와 같은 예시는 나오지 않는다.
     * 1 1 1 1 1
     * 1 1 2 3 1
     * 1 1 1 1 1
     */
    static int N;
    static int M;
    static int R;
    static int[][] box;
    static int[][] rbox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열의 크기
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); // 회전의 수

        box = new int[N][M]; // n * m 배열, 반시계 방향
        rbox = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                box[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int r = 0; r<R;r++){
            for (int k = 0; k < N / 2; k++) {
                int i = k;
                int j = k;

                for (int w = 0; w < 4; w++) { // 0 1 2 3
                    while (true) {
                        int nexti = i + way[w][0];
                        int nextj = j + way[w][1];
                        if (nexti >= k && nexti < N - k && nextj >= k && nextj < M - k) {
                            //System.out.println(i + "," + j);
                            rbox[nexti][nextj] = box[i][j];
                            i = nexti;
                            j = nextj;
                        } else {
                            break;
                        }
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    box[a][b] = rbox[a][b];
                }
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                System.out.print(box[a][b] + " ");
            }
            System.out.println();
        }


    }
}
