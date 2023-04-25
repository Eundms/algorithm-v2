import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> crane; // 크레인 무게 제한
    static List<Integer> boxWeights; // 박스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        boxWeights = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < M; n++) {
            boxWeights.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(boxWeights, Collections.reverseOrder());

        if (boxWeights.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }
        //모든 박스를 배로 옮기는데 드는 시간의 최솟값
        int time = 0;
        while (!boxWeights.isEmpty()) {
            int bIdx = 0;
            int cIdx = 0;
            while (cIdx < N) {
                if (bIdx == boxWeights.size()) {
                    break;
                } else if (crane.get(cIdx) >= boxWeights.get(bIdx)) {
                    boxWeights.remove(bIdx);
                    cIdx++;
                } else {
                    bIdx++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
