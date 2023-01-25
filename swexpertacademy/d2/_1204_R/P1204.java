package swexpertacademy.d2._1204_R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1204 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d2/_1204/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            int[] count = new int[101];
            int maxCount = 0;
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                count[score] += 1;
                if (count[score] > maxCount) {
                    maxCount = count[score];
                }
            }
            int maxNum = -1;
            for (int i = 0; i < 101; i++) {
                if (count[i] != maxCount) {
                    continue;
                }
                maxNum = i;
            }

            System.out.println("#" + test_case + " " + maxNum);

        }
    }
}
