import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 회의의 수
    static int[][] times; // 시작시간, 끝시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        times = new int[N][2];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            times[n][0] = Integer.parseInt(st.nextToken());
            times[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 1;
        int end = times[0][1];
        for (int n = 1; n < N; n++) {
            if (end <= times[n][0]) { // 끝나는 시각 <= 시작하는 시각 : 해당 회의 진행가능
                end = times[n][1];
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
