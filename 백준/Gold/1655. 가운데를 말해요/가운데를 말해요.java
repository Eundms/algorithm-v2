import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> leftPQ;
    static PriorityQueue<Integer> rightPQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        leftPQ = new PriorityQueue<>();
        rightPQ = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            int x = Integer.parseInt(br.readLine()); //백준이가 외치는 수

            if (leftPQ.size() == rightPQ.size()) { // 사이즈가 같다면,
                rightPQ.offer(x); // 최대힙에 저장
            } else {
                leftPQ.offer(x);
            }
            if (!leftPQ.isEmpty() && !rightPQ.isEmpty() ) {
                // 작은값 중 가장 작은 값 > 큰값 중 가장
                if(leftPQ.peek() < rightPQ.peek()){
                    int tmp = leftPQ.poll();
                    leftPQ.offer(rightPQ.poll());
                    rightPQ.offer(tmp);
                }
            }
            sb.append(rightPQ.peek()).append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
