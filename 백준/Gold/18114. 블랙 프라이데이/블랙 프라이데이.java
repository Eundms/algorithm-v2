import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 블랙 프라이데이 https://www.acmicpc.net/problem/18114
    static int N, C;
    static int[] items;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물건의 개수
        C = Integer.parseInt(st.nextToken()); // 딱 이 무게에 맞춰야함

        items = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            items[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items); // 물건의 개수 최대 5000개
        // N개의 물건, 각각의 무게 W
        // 1개 선택 -> C가 있는지 확인
        if (isExist(C)) {
            System.out.println(1);
            return;
        }

        isUsed = new boolean[N];
        // 2개 선택 -> C를 만족하는 두 수가 있는지 확인
        if (isSumExist(C)) {
            System.out.println(1);
            return;
        }
        // 3개 선택 -> C-items[i]를 만족하는 두 수가 있는지 확인 -> two pointer

        for (int i = 0; i < N; i++) {
            isUsed[i] = true;
            if (C - items[i] > 0 && isSumExist(C - items[i])) {
                System.out.println(1);
                return;
            }
            isUsed[i] = false;
        }
        System.out.println(0);
    }

    private static boolean isSumExist(int target) {
        int left = 0, right = N - 1;
        while (left < right) {
            int sumOfTwo = items[left] + items[right];
            if (sumOfTwo == target) {
                if (isUsed[left] || isUsed[right]) { // 방문한적이 있다면
                    left++;
                    right--;
                    continue;
                }
                return true;
            } else if (sumOfTwo < target) {
                left++;
            } else { //sumOfTwo > target
                right--;
            }
        }
        return false;
    }

    private static boolean isExist(int target) {
        int left = 0, right = N - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (items[mid] < target) {
                left = mid + 1;
            } else if (items[left] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
