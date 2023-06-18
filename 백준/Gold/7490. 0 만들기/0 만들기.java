import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static int N;

    public static void main(String[] args) throws IOException { // 행운의 문자열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // xptmxm zpdltmdml rotn
        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            back("1", 2);
            System.out.println();
        }

    }

    private static void back(String str, int num) {
        if (num == N + 1) {
            int sum = 0;
            int number = 0;
            char sign = '+';

            String nStr = str.replace(" ", "");
            for (int i = 0; i < nStr.length(); i++) {
                if (nStr.charAt(i) >= '0' && nStr.charAt(i) <= '9') {
                    number = number * 10 + (nStr.charAt(i) - '0');
                    if (i == nStr.length() - 1) {
                        if (sign == '+') {
                            sum += number;
                        } else {
                            sum -= number;
                        }
                    }
                } else {
                    char item = nStr.charAt(i);
                    if (sign == '+') {
                        sum += number;
                    } else if (sign == '-') {
                        sum -= number;
                    }
                    number = 0;
                    sign = item;
                }

            }
            if (sum == 0) {
                System.out.println(str);
            }
            return;
        }
        back(str + " " + num, num + 1);
        back(str + "+" + num, num + 1);
        back(str + "-" + num, num + 1);

    }
}
