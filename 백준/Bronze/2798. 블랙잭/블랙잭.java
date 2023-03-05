import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int answer;
    private static boolean[] visited;
    private static int[] arr; // N개중
    private static int[] numbers;// 3개 뽑은

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 카드의 개수
        M = Integer.parseInt(st.nextToken()); // 3장의 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N]; // 방문 여부
        numbers = new int[3];
        comb(0, 0,0);
        System.out.println(answer);
    }


    private static void comb(int cnt,int start, int sum) {
        if (cnt == 3) { // 3장의 카드 합은 M을 넘지 않으면서, M과 최대한 가깝게
            if(sum<=M) {
                if (M - answer > M - sum) {
                    answer = sum;
                }
            }
            return;
        }
        for (int i = start; i < N; i++) {
            comb(cnt + 1,i+1, sum + arr[i]);
        }
    }
}
