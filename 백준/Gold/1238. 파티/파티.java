import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 파티 - 다익스트라
    static int N, M, X; // N명의 학생, M개의 단방향 도로, X번 마을
    static List<Node>[] adjList;
    static List<Node>[] adjList2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1 ~ N번 마을
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        adjList2 = new ArrayList[N + 1];
        for (int n = 0; n < N + 1; n++) {
            adjList[n] = new ArrayList<>();
            adjList2[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) { // i번째 도로의 시작, 끝, 소요시간(T_i)
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작점
            int b = Integer.parseInt(st.nextToken()); // 끝점
            int t = Integer.parseInt(st.nextToken()); // 소요시간 T_i
            // 한 도시 A -> B로 가는 도로의 개수 최대 1개
            adjList[a].add(new Node(b, t)); // 시작점 -> (끝점, 소요시간)
            adjList2[b].add(new Node(a, t)); // 시작점 -> (끝점, 소요시간)
        }

        int ans = 0;
        int[] dist1 = dijkstra(adjList);
        int[] dist2 = dijkstra(adjList2);
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(List<Node>[] adjList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.to;
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node next : adjList[cur]) {
                if (!visited[next.to]
                        && dist[next.to] > dist[cur] + next.cost) { // 다음위치로 직접가는게, 현재를 거쳐서 가는 것보다 cost가 큰 경우
                    dist[next.to] = dist[cur] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    // 한 정점 -> 다른 정점 (대신, 다른정점 -> 한 정점 길이 있어야 한다.)
    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
