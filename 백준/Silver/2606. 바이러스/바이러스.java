import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int E;
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V + 1];
        for (int v = 0; v < V + 1; v++) {
            adjList[v] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[V + 1];
        dfs(1);
        int cnt = 0;
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int now) { // 시작 노드
        visited[now] = true;
        for (int next : adjList[now]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dfs(next);
        }
    }
}
