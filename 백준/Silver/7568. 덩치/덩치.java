import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 전체 사람의 수
    static int[][] ppl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 몸무게와 키를 나타내는 양의 정수 x, y
        // 몸무게와 키 모두 크다면, 덩치가 크다
        // 자신보다 큰 덩치의 사람이 K명이라면, 그 사람의 덩치 등수는 K+1이 된다
        N = Integer.parseInt(br.readLine());
        ppl = new int[N][2]; // 전체 사람의 수
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ppl[i][0] = x;
            ppl[i][1] = y;
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if (i != j && ppl[i][0] < ppl[j][0] && ppl[i][1] < ppl[j][1]) {
                    cnt += 1;
                }
            }
            System.out.print(cnt+" ");
        }
        System.out.println();

    }


}
