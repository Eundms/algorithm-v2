import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 순열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int i = N - 2;
        while (i >= 0) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
            i--;
        }

        int j = N - 1;
        if (i < 0) { // 사전 순으로 마지막에 오는 순열
            System.out.println(-1);
        } else { // 다음 순열이 있음
            while (j >= 0) {
                if (arr[j] > arr[i]) {
                    break;
                }
                j--;
            }
            swap(i, j);
            sortFromToEnd(i + 1, arr.length - 1);
            for(int n:arr){
                System.out.print(n+" ");
            }
        }
    }

    private static void sortFromToEnd(int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            swap(startIdx++, endIdx--);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
