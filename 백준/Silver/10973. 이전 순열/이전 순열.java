import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException { // 이전 순열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }
        // 이전 순열 구하기
        int i = N - 2;
        while (i >= 0) {
            if (numbers[i] > numbers[i + 1]) {
                break; //뒤에서부터 탐색해서 내림차순 깨지는...
            }
            i -= 1;
        }
        int j = N - 1;
        if (i >= 0) {
            while (j >= 0) {
                if (numbers[i] > numbers[j]) {
                    break;
                }
                j -= 1;
            }
            swap(i, j);

            sortFromToEnd(i+1,numbers.length-1);

            for(int n : numbers){
                System.out.print(n+" ");
            }

        }else{
            System.out.println(-1);
        }

    }
    private static void sortFromToEnd(int startIdx, int endIdx){
        while(startIdx<endIdx){
            swap(startIdx++,endIdx--);
        }
    }

    private static void swap(int i, int j) {
        int item = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = item;
    }
}
