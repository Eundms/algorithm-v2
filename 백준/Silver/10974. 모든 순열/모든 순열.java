import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N+1];
        permutation(0);
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            arr[cnt] = i;
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}
