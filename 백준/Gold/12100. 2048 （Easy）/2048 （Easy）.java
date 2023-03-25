import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static int N;
    static int[][] box;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        box = new int[N][N]; // 게임판의 초기상태
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(0, box);  // 루트 노드, 계산에 포함되지 않으므로
        System.out.println(answer);
    }

    private static void bt(int depth, int[][] temp) {
        if (depth == 5) {
            answer = Math.max(answer, findMax(temp));// 가장 큰값 구하기
            return;
        }
        // 4가지 방향 중 하나 선택, 중복 가능, 순서 상관있음
        int[][] next = copyMatrix(temp);
        bt(depth + 1, move(next, 1)); // 상
        next = copyMatrix(temp);
        bt(depth + 1, move(next, 0)); // 하
        next = copyMatrix(temp);
        bt(depth + 1, move(next, 3)); // 좌
        next = copyMatrix(temp);
        bt(depth + 1, move(next, 2)); // 우
    }

    private static int[][] copyMatrix(int[][] temp) {
        int[][] next = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                next[i][j] = temp[i][j];
            }
        }
        return next;
    }

    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int[][] move(int[][] temp, int wIdx) {

        // 1. 해당 방향으로 끌어와야 함
        Queue<Integer> queue;
        if (wIdx == 0) { // 하
            for (int j = 0; j < N; j++) { // 열을 옮겨가면서
                queue = new ArrayDeque<>();

                for (int i = N - 1; i >= 0; i--) { // 열마다 뒤와 가까운 값부터 (i=N-1, j=0)
                    if (temp[i][j] != 0) { // 값이 있다면
                        queue.add(temp[i][j]);
                        temp[i][j] = 0;
                    }
                }

                for (int i = N - 1; i >= 0; i--) { // 뒤에서부터 채워넣기
                    if (queue.isEmpty()) {
                        break;
                    }
                    if (queue.size() >= 2) { // 큐에 들어있는 개수가 2개보다 크다면
                        int now = queue.poll(); // 큐에서 poll
                        if (queue.peek() == now) { // 큐 최상위값 == 현재값
                            temp[i][j] = now + queue.poll();
                        } else {
                            temp[i][j] = now;
                        }
                    } else { // 1 이하
                        int now = queue.poll();
                        temp[i][j] = now;
                    }
                }
            }
        } else if (wIdx == 1) { // 상
            for (int j = 0; j < N; j++) { // 열을 옮겨가면서
                queue = new ArrayDeque<>();

                for (int i = 0; i < N; i++) { // 열마다 앞과 가까운 값부터 (i=N-1, j=0)
                    if (temp[i][j] != 0) { // 값이 있다면
                        queue.add(temp[i][j]);
                        temp[i][j] = 0;
                    }
                }

                for (int i = 0; i < N; i++) { // 앞에서부터 채워넣기
                    if (queue.isEmpty()) {
                        break;
                    }
                    if (queue.size() >= 2) { // 큐에 들어있는 개수가 2개보다 크다면
                        int now = queue.poll(); // 큐에서 poll
                        if (queue.peek() == now) { // 큐 최상위값 == 현재값
                            temp[i][j] = now + queue.poll();
                        } else {
                            temp[i][j] = now;
                        }
                    } else { // 1 이하
                        int now = queue.poll();
                        temp[i][j] = now;
                    }
                }
            }
        } else if (wIdx == 2) { // 우
            for (int i = 0; i < N; i++) { // 행을 옮겨가면서
                queue = new ArrayDeque<>();

                for (int j = N - 1; j >= 0; j--) { // 행마다 앞과 가까운 값부터 (i=N-1, j=0)
                    if (temp[i][j] != 0) { // 값이 있다면
                        queue.add(temp[i][j]);
                        temp[i][j] = 0;
                    }
                }

                for (int j = N - 1; j >= 0; j--) { // 앞에서부터 채워넣기
                    if (queue.isEmpty()) {
                        break;
                    }
                    if (queue.size() >= 2) { // 큐에 들어있는 개수가 2개보다 크다면
                        int now = queue.poll(); // 큐에서 poll
                        if (queue.peek() == now) { // 큐 최상위값 == 현재값
                            temp[i][j] = now + queue.poll();
                        } else {
                            temp[i][j] = now;
                        }
                    } else { // 1 이하
                        int now = queue.poll();
                        temp[i][j] = now;
                    }
                }
            }
        } else { // 좌
            for (int i = 0; i < N; i++) { // 행을 옮겨가면서
                queue = new ArrayDeque<>();

                for (int j = 0; j < N; j++) { // 행마다 앞과 가까운 값부터 (i=N-1, j=0)
                    if (temp[i][j] != 0) { // 값이 있다면
                        queue.add(temp[i][j]);
                        temp[i][j] = 0;
                    }
                }

                for (int j = 0; j < N; j++) { // 앞에서부터 채워넣기
                    if (queue.isEmpty()) {
                        break;
                    }
                    if (queue.size() >= 2) { // 큐에 들어있는 개수가 2개보다 크다면
                        int now = queue.poll(); // 큐에서 poll
                        if (queue.peek() == now) { // 큐 최상위값 == 현재값
                            temp[i][j] = now + queue.poll();
                        } else {
                            temp[i][j] = now;
                        }
                    } else { // 1 이하
                        int now = queue.poll();
                        temp[i][j] = now;
                    }
                }
            }
        }
        //printMatrix(temp);
        // 2.
        return temp;
    }

    private static int findMax(int[][] temp) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, temp[i][j]);
            }
        }
        return max;
    }

    private static void printMatrix(int[][] box) {
        System.out.println("------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }

    }
}
