package swexpertacademy.d2._1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1974 {
    private static int[][] box;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d2/_1974_N/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            box = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            if (validate3by3() == true && validate1by9() == true && validate9by1() == true) {
                answer = 1;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static boolean validate1by9() {
        for (int i = 0; i < 9; i++) {
            boolean[] isAppear = new boolean[10];//1-9
            for (int a = 0; a < 10; a++) {
                isAppear[a] = false;
            }
            for (int j = 0; j < 9; j++) {
                if (isAppear[box[i][j]]) {
                    return false;
                }
                isAppear[box[i][j]] = true;
            }
        }
        return true;
    }
    private static boolean validate9by1() {
        for (int i = 0; i < 9; i++) {
            boolean[] isAppear = new boolean[10];//1-9
            for (int a = 0; a < 10; a++) {
                isAppear[a] = false;
            }
            for (int j = 0; j < 9; j++) {
                if (isAppear[box[j][i]]) {
                    return false;
                }
                isAppear[box[j][i]] = true;
            }
        }
        return true;
    }
    private static boolean validate3by3() {
        final int THREE = 3;

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startColumn = 0; startColumn < 9; startColumn+=3) {


                boolean[] isAppear = new boolean[10];//1-9
                for (int a = 0; a < 10; a++) {
                    isAppear[a] = false;
                }
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startColumn; j < startColumn + 3; j++) {
                        if (isAppear[box[i][j]]) {
                            return false;
                        }
                        isAppear[box[i][j]] = true;
                    }
                }


            }
        }
        return true;
    }
}
