import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 등수 구하기
    static int N, SCORE, P;
    static int[] scoreList; // 점수리스트
    static int cnt = 1, rank = 0; // 점수 cnt, 랭킹 cnt

    public static void main(String[] args) throws IOException {
        // 랭킹 리스트에 올라갈 수 없을 정도로 낮다면, -1 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N : 리스트에 있는 점수개수
        SCORE = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수 (랭킹 리스트에서 몇등?)
        P = Integer.parseInt(st.nextToken());// P : 랭킹 리스트에 올라 갈 수 있는 점수의 개수
        if (N == 0) {
            System.out.println(1);
            return;
        }
        scoreList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            scoreList[n] = Integer.parseInt(st.nextToken());
        }

        if (N == P && scoreList[N - 1] >= SCORE) {
            System.out.println(-1);
            return;
        }
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scoreList[i] > SCORE) {
                rank += 1;
            } else {
                break;
            }
        }
        System.out.println(rank);

    }
}
