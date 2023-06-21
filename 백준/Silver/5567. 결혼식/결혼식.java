import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 상근이의 동기 수
    static int M; // 리스트의 길이
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 동기의 수
        M = Integer.parseInt(br.readLine()); // 리스트의 길이
        adjList = new ArrayList[N + 1]; // 인접한 사람 리스트
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 친구 관계
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // 결혼식에 초대할 사람의 수 구하기
        bfs(1);
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            if (visited[item[0]]) {
                continue;
            }
            if(item[1]>=3)break;
            visited[item[0]] = true;
            for (int next : adjList[item[0]]) {
                queue.add(new int[]{next, item[1] + 1});
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                cnt += 1;
            }
        }
        System.out.println(cnt - 1);
    }
}
