import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N; // N개의 로프
    static int K; // k개의 로프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> rope = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            rope.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(rope, Comparator.reverseOrder());

        int minEndureRope = 10000;
        int maxWeight = 0;
        for (int n = 0; n < N; n++) {
            int now = rope.get(n);
            int nowMinEndure = Math.min(minEndureRope, now);
            if (nowMinEndure * (n + 1) > maxWeight) {
                minEndureRope = nowMinEndure;
                maxWeight = nowMinEndure * (n + 1);
            }
        }
        System.out.println(maxWeight);

    }
}
