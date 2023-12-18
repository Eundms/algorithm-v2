import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
	static int N; // 난이도 의견의 개수
	static int minus;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 난이도 의견의 개수 
        if(N == 0) {
        	System.out.println(0);
        	return;
        }
        int[] scores = new int[N];
        for(int n = 0; n < N ; n++) { //사용자들이 제출한 난이도 의견 N개 
        	int s = Integer.parseInt(br.readLine());
        	scores[n] = s;
        }
        Arrays.sort(scores);
        minus = (int)Math.round(0.15 * N) ;
        
        int cnt = 0;
        int sum = 0;
        for(int i = minus; i <N-minus; i++) {
        	cnt +=1;
        	sum += scores[i];
        }
        System.out.println(Math.round((float)(sum)/cnt));
    }
    
}


 