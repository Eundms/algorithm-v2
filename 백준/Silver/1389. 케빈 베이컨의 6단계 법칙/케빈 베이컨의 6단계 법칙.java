import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        int[] res = new int[N + 1];

        adjList = new ArrayList[N + 1]; // 1 ~ N
        for (int n = 0; n < N + 1; n++) {
            adjList[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) { // 친구 관계
            // A <-(친구)-> B
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        // 한점 다른 모든 점까지 거리
        for (int start = 1; start < N + 1; start++) { //1번

            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            boolean[] visit = new boolean[N + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
            pq.add(new int[]{start, 0});
            dist[start] = 0;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                if (visit[current[0]]) {
                    continue;
                }
                visit[current[0]] = true;

                for (int next : adjList[current[0]]) {
                    if (dist[next] > dist[current[0]] + 1) {
                        dist[next] = dist[current[0]] + 1;
                        pq.add(new int[]{next, dist[next]});
                    }
                }

            }


            int value = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    value += dist[j];
                }
            }
            res[start] = value;


        }


        int minv = 0;
        int min = Integer.MAX_VALUE;
        // 케빈 베이컨의 수가 가장 작은 사람..!
        for (int v = 1; v <= N; v++) {
            if (res[v] < min) {
                minv = v;
                min = res[v];
            }
        }

        System.out.println(minv);

    }

}
