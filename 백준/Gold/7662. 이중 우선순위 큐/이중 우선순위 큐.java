import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main { // 트리맵 - 조건 : 동일한 정수가 삽입될 수 있음
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> queue = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    queue.put(n, queue.getOrDefault(n, 0) + 1);
                } else {
                    if (queue.size() == 0) {
                        continue;
                    }
                    int num = 0;
                    if (n == 1) {
                        num = queue.lastKey();
                    } else {
                        num = queue.firstKey();
                    }
                    if (queue.put(num, queue.get(num) - 1) == 1) {
                        queue.remove(num);
                    }
                }
            }
                            System.out.println(queue.size() == 0 ? "EMPTY" : queue.lastKey() + " " + queue.firstKey());

        }

    }
}
