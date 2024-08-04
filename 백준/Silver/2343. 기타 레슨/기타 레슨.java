import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int N, M; 
	static int[] length;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		length = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			length[n] = Integer.parseInt(st.nextToken());
			end += length[n];
			start = Math.max(start, length[n]);
		}

		int ans = 0;
		while(start<=end) {
			int mid = (start + end) / 2; // 블루레이 크기가 최소가 되는 크기
			
			int group = 0;
			int count = 1;
			for(int l : length) {
				if (group + l > mid) { // mid값이 그룹합의 최대가 되어야 하므로 
					count += 1; // 그룹 하나 만듦
					group = 0;
				}
				group += l;
			}
			if (count <= M) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
        System.out.println(ans);
	}
}