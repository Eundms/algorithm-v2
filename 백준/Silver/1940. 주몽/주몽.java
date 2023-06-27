import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M; // 재료의 개수, 갑옷을 만드는 데 필요한 수
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료의 개수
        M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            if (arr[i] + arr[j] == M) {
                i += 1;
                cnt += 1;
            } else if (arr[i] + arr[j] < M) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        System.out.println(cnt);
    }
}