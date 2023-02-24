import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {//ABCDE
    /**
     * 5 5
     * 0 1
     * 1 3
     * 1 4
     * 4 3
     * 3 2
     */
    static int N, M; //사람의 수, 친구 관계의 수
    static List<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        friends = new LinkedList[N]; // 0번 ~ N-1
        for (int m = 0; m < N; m++) {
            friends[m] = new LinkedList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //정수 a
            int b = Integer.parseInt(st.nextToken()); //정수 b
            // a - b : 친구
            friends[a].add(b);
            friends[b].add(a);
        }
        int res = 0;
        for (int n = 0; n < N; n++) {
            boolean[] visited = new boolean[N];
            if (dfs(n, 0, visited)) {
                res = 1;
                break;
            }
        }
        System.out.println(res);

    }

    private static boolean dfs(int now, int cnt, boolean[] visited) {
        visited[now] = true;
        if (cnt == 4) { // A B C D E가 존재하는 경우
            return true;
        }
        for (int next : friends[now]) { // 다음 노드에 대해서
            if (visited[next]) continue;
            if (dfs(next, cnt + 1,visited)) {
                return true;
            }
        }
        visited[now] = false; //실패한 경우 친구관계를 되돌려야 한다.

        return false;
    }
}
