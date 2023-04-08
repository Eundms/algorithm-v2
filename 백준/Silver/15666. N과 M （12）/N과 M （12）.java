import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // N개중 M개 고르기
    static int[] arr;
    static int[] num;
    static LinkedHashSet<String> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        result = new LinkedHashSet<>();
        num = new int[M];
        comb(0, 0);

        result.forEach(System.out::println);
    }

    static void comb(int cnt, int start) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(num[i] + " ");
            }
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < N; i++) { // for문의 수가 의미하는 바
            num[cnt] = arr[i];  //num 배열에 무엇을 저장할 것인지
            comb(cnt+1,i);
        }
    }
}