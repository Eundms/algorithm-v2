import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    // 주어진 수의 순서 고정
    static int N; // 수의 개수
    static int K; // N개중 K개 선택 ->순서 영향 있음
    static int[] arr;
    static boolean[] visited;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // n장의 카드
        K = Integer.parseInt(br.readLine()); // k개 선택
        arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
        visited = new boolean[N];
        back(0,"");
        System.out.println(set.size());
    }

    static void back(int cnt, String numstr) {
        if (cnt == K) {
            set.add(numstr);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            back(cnt + 1, numstr + arr[i]);
            visited[i] = false;
        }
    }


}
