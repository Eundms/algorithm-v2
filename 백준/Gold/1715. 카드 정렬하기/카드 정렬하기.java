import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(0);
            return;
        }
        pq = new PriorityQueue<>(); // 1 - 3
        for (int n = 0; n < N; n++) {
            pq.add(Integer.parseInt( br.readLine()));
        }

        int res = 0;
        while(!pq.isEmpty()){
            if(pq.size()>2){
                int item = pq.poll() + pq.poll();
                res += item;
                pq.offer(item);
            }else if(pq.size()==2){
                res += pq.poll() + pq.poll();
            }
        }
        
        System.out.println(res);
    }
}
