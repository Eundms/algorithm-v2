import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] rides;
	static int maxM;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 아이들 수
		M = Integer.parseInt(st.nextToken()); // 놀이기구 종류

		st = new StringTokenizer(br.readLine());
		rides = new int[M]; // 놀이기구 운행시간
		for (int m = 0; m < M; m++) {
			rides[m] = Integer.parseInt(st.nextToken());
			maxM = Math.max(rides[m], m);
		}
		// 1 2 3 4 5 (초)
		// 1 2 3 4 5
		// 6
		// 7
		// N초에 몇명의 아이들이 타는가?
		// 그럼 N초까지 각 놀이기구에 탄 인원은 어떻게 되는가
		// 모든 아이들이 놀이기구에 탑승할 수 있는 최소 시간은 어떻게 되는가

		if (N <= M) {
			System.out.println(N);
			return;
		}
		// 1. 모든 아이들이 놀이기구에 탑승한 최소 시간(minTime) 구하기 << 이분탐색
		// 2. (minTime-1)초까지 놀이기구에 탑승한 아이들 수 구하기
		// 3. minTime에 놀이기구에 탑승할 아이들 수 = 총아이들 수 - (minTime-1)초까지 놀이기구에 탑승한 아이들 수
		// 4. 놀이기구 순서대로 minTime에 학생이 탑승하는지 확인 >> 마지막 그 놀이기구 == 마지막 학생이 탑승하는 놀이기구
		long minTime = Long.MAX_VALUE;
		long left = 0, right = N * 30L; // N명 x 운행시간최대 30
		while (left <= right) {
			long time = (right - left) / 2 + left; // 범위 안벗어나도록
			if (rideCnt(time) >= N) {
				right = time - 1;
				minTime = time;
			} else {
				left = time + 1;
			}
		}

		long childRideCnt = rideCnt(minTime - 1);
		for (int i = 0; i < M; i++) {
			if (minTime % rides[i] == 0) { // minTime에 이용가능한 놀이기구
				childRideCnt += 1;
			}
			if (childRideCnt == N) {
				System.out.println(i + 1);
				return;
			}
		}

	}

	static long rideCnt(long time) {

		long cnt = M; // 빈 상태로 시작하기 때문에 1초에 다 탈 수 있음
		for (int i = 0; i < M; i++) {
			cnt += time / rides[i]; // 특정 시각까지 특정 놀이기구에 탄 인원수
		}
		return cnt;
	}

}
