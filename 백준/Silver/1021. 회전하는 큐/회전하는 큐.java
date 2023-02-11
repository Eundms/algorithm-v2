import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static LinkedList<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 큐의 크기
        M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int m = 0; m < M; m++) {
            int location = Integer.parseInt(st.nextToken());
            int idx = queue.indexOf(location);


            if(idx > Math.abs(queue.size()-idx)){ // 뒤 가까움

                for(int j = 0; j<queue.size()-idx;j++){
                    int temp = queue.pollLast();
                    queue.offerFirst(temp);
                    res++;
                }
            }else {

                for(int j = 0; j<idx;j++){
                    int temp = queue.pollFirst();
                    queue.offerLast(temp);
                    res++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(res);

    }
}
