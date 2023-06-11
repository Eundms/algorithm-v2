import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // n개의 서로 다른 양의 정수
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(br.readLine());

        Arrays.sort(num);
        int cnt = 0;
        int left = 0, right = N - 1;
        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == target) {
                cnt += 1;
                left += 1;
            } else if (sum > target) {
                right -= 1;
            } else { // sum < target
                left += 1;
            }
        }
        System.out.println(cnt);

    }
}