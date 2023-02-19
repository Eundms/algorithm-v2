import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 외판원 순회2
    static boolean[] visited;
    /**
     * 단방향 간선 간선의 비용은 양의 정수 가장 적은 비용 원래 자리로 돌아와야 함
     */
    static int N; // 도시의 수
    static int[][] adjMatrix; // 비용 행렬
    static int minDistance = Integer.MAX_VALUE;
    static int start; //시작 지점

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N + 1][N + 1]; // i->j 위한 비용

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 비용행렬, 순회할 수 있는가
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            start = i;
            dfs(i, 0);
        }
        System.out.println(minDistance);
    }

    private static void dfs(int now, int sum) {
        if (allVisited()) { //모두 방문했다면
            if (adjMatrix[now][start] != 0) { //다시 시작지점으로 돌아올 수 있다면
                minDistance = Math.min(sum + adjMatrix[now][start], minDistance);
            }
            return;
        }

        for (int next = 1; next <= N; next++) {
            if (adjMatrix[now][next] == 0 || visited[next]) {
                continue;
            }
            visited[next] = true;
            dfs(next, sum + adjMatrix[now][next]);
            visited[next] = false;
        }
    }

    private static boolean allVisited() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
