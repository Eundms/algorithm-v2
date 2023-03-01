import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//크루스칼 => 간선
// prim => 노드
public class Main {
    static int V, E; //정점, 간선
    static List<Edge> edgeList;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수 10,000
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        edgeList = new ArrayList<>();
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(A, B, C));
        }

        Collections.sort(edgeList);

        parent = new int[V + 1]; //1 ~V번 부모
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        depth = new int[V + 1]; // 깊이

        int mstEdgeNum = V - 1;
        int sumOfWeight = 0;
        for (int e = 0; e < E; e++) {
            if (union(edgeList.get(e).a, edgeList.get(e).b)) {
                sumOfWeight += edgeList.get(e).weight;
                mstEdgeNum--;
            }
            if (mstEdgeNum == 0) {
                break;
            }
        }
        System.out.println(sumOfWeight);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        if (depth[a] < depth[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
        if (depth[a] == depth[b]) {
            depth[a]++;
        }
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<Edge> {
        int a, b, weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
