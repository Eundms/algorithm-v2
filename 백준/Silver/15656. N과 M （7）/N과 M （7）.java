import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 자연수 N과 M
    static boolean[] visited;
    static int[] arr;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    // 1 ~ N 자연수 중 M개 고르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[N + 1]; // 방문 1~ N
        numbers = new int[M];
        perm(0);
        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) { // 길이가 M인 수열
            for (int m = 0; m < M; m++) {
                sb.append(numbers[m] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            //if(visited[i])continue;
            visited[i]=true;
            numbers[cnt] = arr[i];
            perm(cnt + 1);
            visited[i]=false;
        }
    }
}
