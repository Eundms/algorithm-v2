import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 전체 사람의 수
        adjList = new ArrayList[N + 1];
        for (int n = 0; n < N + 1; n++) {
            adjList[n] = new ArrayList<>();
        }
        // 촌수를 계산해야 하는 두사람의 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 부모 자식들 간의 관계의 개수
        M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine()); // 부모 자식 간의 관계
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        System.out.println(bfs(A, B));

    }

    private static int bfs(int start, int end) {
        boolean[] visited = new boolean[N + 1]; // 1~ N
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == end) {
                return now[1];
            }
            for (int next : adjList[now[0]]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(new int[]{next, now[1] + 1});
            }
        }

        return -1;
    }
}
