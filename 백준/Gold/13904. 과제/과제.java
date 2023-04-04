import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { //과제
    static int N; // 정수 N
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // idx, score
        }

        int[] hw = new int[1000 + 1];

        while (!pq.isEmpty()) { // 남은 일수 1 ~ 1000
            Node now = pq.poll();
            for (int hwDay = now.limit; hwDay > 0; hwDay--) { // 제일 늦게 과제 하기
                if (hw[hwDay] == 0) {
                    hw[hwDay] = now.score;
                    break;
                } else if (hw[hwDay] < now.score) {
                    hw[hwDay] = now.score;
                    break;
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i<=1000;i++){
            cnt += hw[i];
        }
        System.out.println(cnt);

    }

    static class Node implements Comparable<Node> {
        int limit, score;

        public Node(int limit, int score) {
            this.limit = limit;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return o.score - this.score; // 내림차순 정렬
        }
    }
}
