import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //캠프준비
    private static boolean[] visited;
    private static int N;
    private static int L;
    private static int R;
    private static int X;
    private static int[] difficulty;
    private static int totalCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 총 문제수
        L = Integer.parseInt(st.nextToken()); // 문제 난이도 합 >= L
        R = Integer.parseInt(st.nextToken()); // 문제 난이도 합 <= R
        X = Integer.parseInt(st.nextToken()); // 가장 어려운 문제 - 가장 쉬운 문제의 난이도 >= X

        visited = new boolean[N];
        difficulty = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            difficulty[n] = Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(totalCnt);
    }

    private static void subset(int cnt) {//N개중 2문제 이상
        if (cnt == N) {
            int hardCnt=0;
            int hard = 0;
            int maxHard = Integer.MIN_VALUE;
            int minHard = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {//visited
                if (visited[i]) {
                    hardCnt+=1;
                    hard += difficulty[i];
                    maxHard = Math.max(difficulty[i],maxHard);
                    minHard = Math.min(difficulty[i],minHard);
                    //System.out.print(difficulty[i]+" ");
                }
            }

            if (hardCnt>=2 && hard >= L && hard <= R && maxHard-minHard>=X) {
                totalCnt++;
            }
            return;
        }
        visited[cnt] = true;
        subset(cnt + 1);

        visited[cnt] = false;
        subset(cnt + 1);
    }
}
