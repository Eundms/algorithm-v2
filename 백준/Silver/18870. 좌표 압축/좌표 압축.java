import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] xList;
    static int[] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        xList = new int[N];
        origin = new int[N];
        for (int n = 0; n < N; n++) {
            xList[n] = Integer.parseInt(st.nextToken());
            origin[n] = xList[n];
        }
        Arrays.sort(xList);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int v : xList) {
            if (!rankMap.containsKey(v)) {
                rankMap.put(v, rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int key: origin) {
            sb.append(rankMap.get(key)+" ");
        }
        System.out.println(sb);

    }


}
