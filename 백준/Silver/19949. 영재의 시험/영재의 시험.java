import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main {// 19949
	static int[] arr = new int[10];
	static int answer;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 10; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1-5중 하나 선택 10가지 경우의 수에 대해
        score(0, new int[10]);
        System.out.println(answer);
    }
	static void score(int cnt, int[] ans) {
		if(cnt==10) {
			int temp = 0;
			for(int i = 0; i < 10; i++) {
				if(i<8 && ans[i]==ans[i+1]&& ans[i+1]==ans[i+2])return;
				if(ans[i]==arr[i])temp+=1;
			}
			if(temp>=5) {
				answer+=1;
			}
			return;
		}
		for(int value = 1; value <= 5; value++) {
			ans[cnt] = value;
			score(cnt+1, ans);
		}
	}



}

 