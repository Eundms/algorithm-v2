import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tobni; // 톱니바퀴 : 1번 톱니바퀴, 2번 톱니바퀴, 3번 톱니바퀴, 4번 톱니바퀴
    static List<Integer>[] copyed;
    static int K;

    public static void main(String[] args) throws IOException {
        tobni = new LinkedList[4];
        copyed = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            tobni[i] = new LinkedList<>();
            copyed[i] = new LinkedList<>();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String items = br.readLine();
            for (int j = 0; j < items.length(); j++) {
                tobni[i].add(items.charAt(j) - '0');
                copyed[i].add(items.charAt(j) - '0');
            }
        }

        StringTokenizer st;
        K = Integer.parseInt(br.readLine()); // 회전 횟수
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int tobniNum = Integer.parseInt(st.nextToken()) - 1; //  0 ~ 3
            int way = Integer.parseInt(st.nextToken()); // 1: 시계, -1 반시계

            /** 일단 시계 이동 **/
            if (way == 1) { // 시계, popLast addFirst
                clockWise(way, tobniNum);
            } else { // 반시계, popFirst addLast
                reverseClockWise(way, tobniNum);
            }
            // "2 6 번째가 같은지 비교"해야 함 -> 톱니바퀴
            int nway = way * -1;
            int prev = tobniNum;
            for (int i = tobniNum + 1; i < 4; i++) {
                if (tobni[prev].get(2) == tobni[i].get(6)) {
                    break;
                }
                // 여기서
                if (nway == 1) {
                    clockWise(nway, i);
                } else {
                    reverseClockWise(nway, i);
                }
                prev = i;
                nway *= -1;
            }
            nway = way * -1;
            prev = tobniNum;
            // "2 6 번째가 같은지 비교"해야 함 < - 톱니바퀴
            for (int i = tobniNum - 1; i >= 0; i--) {
                if (tobni[prev].get(6) == tobni[i].get(2)) {
                    break;
                }
                // 여기서
                if (nway == 1) {
                    clockWise(nway, i);
                } else {
                    reverseClockWise(nway, i);
                }
                prev = i;
                nway *= -1;
            }
            tobni = copy(copyed);
        }

        System.out.println(calculate());
    }

    private static List<Integer>[] copy(List<Integer>[] tobni) {
        List<Integer>[] newOne = new ArrayList[4];
        for(int i=0;i<4;i++){
            newOne[i] = new ArrayList<>();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                newOne[i].add(tobni[i].get(j));
            }
        }
        return newOne;
    }

    private static int calculate() {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num += tobni[i].get(0) == 0 ? 0 : Math.pow(2, i);
        }
        return num;
    }

    private static void clockWise(int way, int tobniNum) {
        copyed[tobniNum].add(0, copyed[tobniNum].remove(7));

    }

    private static void reverseClockWise(int way, int tobniNum) {
        copyed[tobniNum].add(7, copyed[tobniNum].remove(0));
    }

    private static void printTobni(String word, List<Integer>[] array) {
        for (int i = 0; i < 4; i++) {
            System.out.println(array[i]);
        }
    }
}
