package swexpertacademy.d2._1209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1209 {
    public static int maxRow() {
        int maxSum = 0;
        for (int r = 0; r < 100; r++) {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += box[r][i];

            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maxColumn() {
        int maxSum = 0;
        for (int r = 0; r < 100; r++) {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += box[i][r];

            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maxLeft2Right() {
        int sum = 0;
        for (int r = 0; r < 100; r++) {
            sum += box[r][r];
        }
        return sum;
    }

    public static int maxRight2Left() {
        int sum = 0;
        for (int r = 0; r < 100; r++) {
            sum += box[r][99 - r];
        }
        return sum;
    }

    private static int[][] box;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d2/_1209/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        for (int testCase = 1; testCase <= 10; testCase++) {
            Integer.parseInt(br.readLine());

            box = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }

            }
            int value = Math.max(Math.max(maxRow(), maxColumn()), Math.max(maxLeft2Right(), maxRight2Left()));
            System.out.println("#" + testCase + " " + value);
        }

    }
}
