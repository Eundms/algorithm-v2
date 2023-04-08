import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num;
    static boolean[] visited;
    static int[] selected;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 자연수 중
        M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
        num = new int[N];
        visited = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            num[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        ans = new LinkedHashSet<>();
        comb(0);
        ans.forEach(System.out::println);
    }

    private static void comb(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int m = 0; m < M; m++) {
                sb.append(selected[m]+" ");
            }
            ans.add(sb.toString());
            return;
        }
        for (int n = 0; n < N; n++) {
            if(visited[n]) continue;
            visited[n] = true;
            selected[cnt] = num[n];
            comb(cnt + 1);
            visited[n] = false;

        }
    }
}
