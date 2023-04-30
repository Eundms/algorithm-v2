import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Lecture[] list;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new Lecture[N ];

        StringTokenizer st ;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i] = new Lecture(a, b);
        }
        Arrays.sort(list);

        pq = new PriorityQueue<>();
        pq.offer(list[0].endTime);
        for (int n = 1; n < N; n++) {
            if (pq.peek() <= list[n].startTime) {
                pq.poll();
            }
            pq.offer(list[n].endTime);
        }
        System.out.println(pq.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int startTime, endTime; // S 시작 -> T 끝나는 N개의 수업

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }

}
