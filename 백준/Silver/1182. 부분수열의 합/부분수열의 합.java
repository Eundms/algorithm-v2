import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정수 나타내는 N
        S = Integer.parseInt(st.nextToken()); // 정수 S

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //합이 S가 되는 부분 수열의 개수?
        visited = new boolean[N];
        subset(0);
        System.out.println(res);
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            int cntObj=0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    cntObj+=1;
                    sum += arr[i];
                }
            }
            if (sum == S && cntObj>0) {
                res +=1;
            }
            return ;
        }
        visited[cnt] = true;
        subset(cnt + 1);

        visited[cnt] = false;
        subset(cnt + 1);
    }
}
