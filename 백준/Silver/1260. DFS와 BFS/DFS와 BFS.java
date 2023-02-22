import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 입력으로 주어지는 간선은 양방향
     * 정점 번호는 1번부터 N번까지
     * 어떤 두 정점 사이에 여러 개의 간선 있을 수 있음
     */
    static int N, M; //정점의 개수 N, 간선의 개수 M
    static int V;
    static List[] adjList;//정점 번호는 1번부터 N번까지
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
        adjList = new ArrayList[N + 1];//정점이 1~N까지 이므로
        for (int n = 1; n <= N; n++) {
            adjList[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) { //m개의 줄에는 간선 정점 번호
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(adjList[i]);
        }
        visited = new boolean[N + 1];//1~N까지 사용
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];//1~N까지 사용
        bfs(V);
    }

    private static void dfs(int now) {
        visited[now] = true;
        System.out.print(now+" ");
        List<Integer> nexts = adjList[now];
        for (int next:nexts) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }

    private static void bfs(int now) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(now);
        visited[now] = true;
        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x+" ");
            List<Integer> nexts = adjList[x];
            for(int next:nexts){
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }
    }
}
