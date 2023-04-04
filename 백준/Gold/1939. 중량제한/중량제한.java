import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {// 중량제한
    static int N, M;
    static List<Node>[] adjList;
    static int start, end;
    static int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    static int mid;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 간선수

        adjList = new ArrayList[N + 1];//섬번호 1~ N
        for (int n = 0; n < N + 1; n++) {
            adjList[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[i].add(new Node(j, cost));
            adjList[j].add(new Node(i, cost));
            low = Math.min(cost, low);
            high = Math.max(cost, high);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (low <= high) {
            mid = (low + high) / 2; // mid가 상한이 된다.
            if (bfs()) { // 갈 수 있는 경로가 있는 경우
                low = mid + 1; //상한 올려보기
            }else{ // 갈 수 있는 경로가 없는 경우
                high = mid -1; // 하한 내려보기
            }
        }
        System.out.println(max);
    }

    private static boolean bfs() { //
        boolean[] visited = new boolean[N + 1];// 1~ N

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.j]) continue;
            visited[now.j] = true;

            if (now.j == end) {
                max = Math.max(max,now.cost);
                return true;
            }
            for (Node next : adjList[now.j]) {// 인접노드에 대해서
                if (visited[next.j]) continue;
                if (mid <= next.cost) {
                    queue.add(new Node(next.j, Math.min(now.cost,next.cost)));
                }
            }

        }
        return false;
    }

    static class Node {
        int j, cost;

        public Node(int j, int cost) {
            this.j = j;
            this.cost = cost;
        }
    }
}
