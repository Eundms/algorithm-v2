import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 18808
	static int NOTEBOOK_ROW, NOTEBOOK_COL, STICKER_CNT; // 세로, 가로, 스티커의 개수
	static int[][] box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		NOTEBOOK_ROW = Integer.parseInt(st.nextToken());
		NOTEBOOK_COL = Integer.parseInt(st.nextToken());
		STICKER_CNT = Integer.parseInt(st.nextToken());
		
		box = new int[NOTEBOOK_ROW][NOTEBOOK_COL];
		for(int s = 0; s < STICKER_CNT; s++) {
			st = new StringTokenizer(br.readLine());
			int STICKER_ROW = Integer.parseInt(st.nextToken()); // 행의 개수
			int STICKER_COL = Integer.parseInt(st.nextToken()); // 열의 개수
			int[][] sticker = new int[STICKER_ROW][STICKER_COL]; // 붙여야 하는 스티커
			for(int i = 0; i < STICKER_ROW; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < STICKER_COL; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int rotCnt = 0;
			// 붙이는 거 시도한다
			while(rotCnt++ < 4) {
				boolean findAnswer = false;
				
				for(int i = 0; i < NOTEBOOK_ROW; i++) {
					for(int j = 0; j < NOTEBOOK_COL; j++) { // 스티커 시작 위치 구하기 
						if(!isStickerInRange(i, j, sticker.length, sticker[0].length)) {
							continue;
						}
						int[][] temp = copy(box);
						boolean isAnswer = true;
						for(int m = 0; m < sticker.length; m++) {
							for(int n = 0; n < sticker[0].length; n++) {
								if(sticker[m][n] == 1 && box[i+m][j+n] == 1) {
									isAnswer = false;
									break;
								}
								if(sticker[m][n] == 1) {
									temp[i+m][j+n] = 1;		
								}
							}
							if(!isAnswer)break;
						}
						if(isAnswer) {
							box = copy(temp);
							findAnswer = true;
							break;
						}
					}
					if(findAnswer) {
						break;
					}
				}
				if(findAnswer) {
					break;
				}
				sticker = rotate(sticker);
			}
			//printBox();
			
		}
		int cnt = 0;
		for(int i = 0; i < box.length; i++) {
			for(int j = 0; j < box[0].length; j++) {
				cnt += box[i][j];
			}
		}
		System.out.println(cnt);
		
	}
	static boolean isStickerInRange(int i, int j, int stickerRowSize, int stickerColSize) {
		int maxI = i + stickerRowSize - 1;
		int maxJ = j + stickerColSize - 1;
		return maxI < NOTEBOOK_ROW && maxJ < NOTEBOOK_COL;
	}
	// 스티커 회전 N * M -> M * N 
	static int[][] rotate(int[][] sticker){
		int[][] temp = new int[sticker[0].length][sticker.length];
		// (i,j) -> j , sticker.length-1-i
		for(int i = 0; i < sticker.length ; i++) {
			for(int j = 0; j < sticker[0].length; j++) {
				temp[j][sticker.length-1-i] = sticker[i][j];
			}
		}
		return temp;
	}
	static int[][] copy(int[][] box) {
		int[][] temp = new int[box.length][box[0].length];
		for(int i = 0; i < box.length; i++) {
			for(int j = 0; j < box[0].length; j++) {
				temp[i][j] = box[i][j];			
			}
		}
		return temp;
	}
	static void printBox() {
		for(int i = 0; i < box.length ; i++) {
			for(int j = 0; j < box[0].length; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}