import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {  
	static int FILE_CNT;
	static int[] fileSize;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FILE_CNT = Integer.parseInt(br.readLine()); // 토핑의 종류의 수
		// 각 솔루션 파일의 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		fileSize = new int[FILE_CNT];
		for(int i = 0; i < FILE_CNT; i++) {
			fileSize[i] = Integer.parseInt(st.nextToken());
		}
		long cnt = 0;
		Arrays.sort(fileSize);
		for(int i = 0; i < FILE_CNT; i++) { // 고정되어있음
			cnt += (findJ(i) - i);
		}
		// 총 N명, 솔루션 파일 1개 : F1, F2, ..., Fn
		System.out.println(cnt);
	}
	static int findJ(int i) {// i 보다 오른쪽 수 중 Fi >= 0.9 * Fj 를 만족하는 수를 찾으면 된다
		int result = i;
		int left = i+1, right = FILE_CNT-1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(fileSize[i] >= fileSize[mid] * 0.9) {
				result = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return result;
	}
}