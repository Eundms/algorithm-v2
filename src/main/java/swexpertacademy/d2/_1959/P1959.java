package swexpertacademy.d2._1959;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1959 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d2/_1959/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            List<Integer> B = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            int maxSum = 0;

            for (int pre = 0; pre < Math.abs(N - M) + 1; pre++) {
                int tempSum = 0;
                if (N > M) {
                    for (int idx = 0; idx < M; idx++) {
                        tempSum += A.get(idx + pre) * B.get(idx);
                    }
                } else {
                    for (int idx = 0; idx < N; idx++) {
                        tempSum += B.get(idx + pre) * A.get(idx);
                    }
                }
                maxSum = Math.max(maxSum, tempSum);

            }
            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}
