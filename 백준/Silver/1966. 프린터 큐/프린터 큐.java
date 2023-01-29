import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 몇번째 인쇄?
            st = new StringTokenizer(br.readLine());

            int[] whenPrint = new int[N];
            int[] priority = new int[N];
            Queue<Integer> docs = new LinkedList<>();//번호 넣기
            for (int n = 0; n < N; n++) {
                docs.add(n); // 번호
                priority[n] = Integer.parseInt(st.nextToken());//문서 중요도
            }
            int printCount=1;
            while (!docs.isEmpty()) { // 비어있지 않다면
                int index = docs.poll(); // 인덱스
                int priorityItem = priority[index]; // 우선순위
                if(canPrint(priorityItem,priority,docs)){
                    whenPrint[index]=printCount++;
                    continue;
                }
                docs.add(index);


            }
            System.out.println(whenPrint[M]);

        }
    }
    public static boolean canPrint(int priorityItem, int[] priority, Queue<Integer> docs){
        for(int doc:docs){
            if(priority[doc]>priorityItem){
                return false;
            }
        }
        return true;
    }

}
