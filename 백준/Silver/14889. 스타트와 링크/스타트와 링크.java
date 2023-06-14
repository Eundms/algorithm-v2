import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[] picked;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 배열의 크기
        box = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // N/2
        picked = new boolean[N];
        comb(0,0);
        System.out.println(minValue);
    }

    static void comb(int cnt, int start) {
        if (cnt == N / 2) {
            int teamA = 0, teamB = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (picked[i]==true && picked[j]==true) {
                        teamA += box[i][j];
                    } else if(picked[i]==false && picked[j]==false){
                        teamB += box[i][j];
                    }
                }
            }
            minValue = Math.min(minValue, Math.abs(teamA - teamB));
            return;
        }
        for (int i = start; i < N; i++) {
            picked[i] = true;
            comb(cnt + 1, i + 1);
            picked[i] = false;

        }

    }

}
