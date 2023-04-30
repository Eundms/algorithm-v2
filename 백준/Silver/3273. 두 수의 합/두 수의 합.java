import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N; // 수열의 크기
    static int[] arr; // 수열에 포함되는 수;
    static int X; // 자연수 X

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N개의 서로 다른 양의 정수
        arr = new int[N]; // N개의 서로 다른 양의 정수

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        //System.out.println(" >> "+Arrays.toString(arr));

        int cnt = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == X) {
                //System.out.println(arr[i] + " + " + arr[j] + " = " + X);
                cnt += 1;
                i++;
            } else if (sum > X) {
                j--;
            } else { // sum < X
                i++;
            }
        }
        System.out.println(cnt);
    }


}
