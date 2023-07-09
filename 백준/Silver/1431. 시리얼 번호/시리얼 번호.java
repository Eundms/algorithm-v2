import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N; // 기타의 개수

    public static void main(String[] args) throws Exception {
        PriorityQueue<Serial> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(new Serial(br.readLine()));
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll().name);
        }
    }

    static class Serial implements Comparable<Serial> {
        private String name;

        public Serial(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Serial o) {
            if (this.name.length() == o.name.length()) { // 길이가 같다면, A의 모든 자리수의 합 , B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 옴
                int sumA = 0;
                for (int i = 0; i < this.name.length(); i++) {
                    char item = this.name.charAt(i);
                    if (item >= '0' && item <= '9') {
                        sumA += (item - '0');
                    }
                }
                int sumB = 0;
                for (int j = 0; j < o.name.length(); j++) {
                    char item = o.name.charAt(j);
                    if (item >= '0' && item <= '9') {
                        sumB += (item - '0');
                    }
                }
                if(sumA == sumB){
                    return this.name.compareTo(o.name);
                }
                return sumA - sumB;
            }
            return this.name.length() - o.name.length();// A와 B의 길이가 다르면, 짧은 것이 먼저 옴
        }
    }
}
