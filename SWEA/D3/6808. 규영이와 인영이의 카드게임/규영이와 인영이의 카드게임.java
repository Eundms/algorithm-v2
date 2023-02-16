import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    /**
     * 1 - 18 카드 18장으로 게임
     * 9장씩 카드를 나눠 가짐
     * 9라운드 진행 : 카드에 적힌 수 비교해서 점수 계산
     * 높은 수 : + (A+B)
     * 낮은 수 : 0
     * 총점 높은 사람
     * 규영(A)의 카드 순서 고정 => 인영(B)의 카드 순서에 따라 승패 정해짐
     * 규영(A)의 이기는 경우와 지는 경우가 총 몇가지 인가?
     */
    static int T;
    static int[] aArr; // 규영이 카드 (고정)
    static int[] bArr; // 인영이 카드 Pool
    static boolean[] bVisited;
    static int[] bNumbers; // 인영이 카드 순서

    static int totalKuWinCnt;
    static int totalKuLossCnt;
    public static void main(String[] args) throws IOException {//6808. 규영이와 인영이의 카드게임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            boolean[] card = new boolean[19];// 1 ~ 18 : B를 구하기 위한 변수
            aArr = new int[9]; // 9개의 정수 : 규영(A)의 보유 카드와 그 순서
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                aArr[i] = Integer.parseInt(st.nextToken());
                card[aArr[i]] = true;
            }
            bArr = new int[9];
            // 인영(B)의 보유 카드 (1 - 18에서 규영(A)의 보유카드 제외)
            for (int cardNo = 1, b = 0; cardNo <= 18; cardNo++) {
                if (!card[cardNo]) {
                    bArr[b++] = cardNo;
                }
            }

            totalKuWinCnt = 0;
            totalKuLossCnt = 0;
            // 인영이의 보유 카드를 순열구하기
            bVisited = new boolean[9];
            bNumbers = new int[9]; // 순서 넣는 배열
            permutation(0);

            System.out.println("#"+t+" "+totalKuWinCnt+" "+totalKuLossCnt);
        }
    }

    private static void permutation(int cnt) {
        if (cnt == 9) {
            int kuScore = 0;//규영 점수
            int inScore = 0; //인영 점수
            for (int i = 0; i < 9; i++) {
                // aArr와 bArr[bNumbers[i]] 비교하여 점수 계산
                if (aArr[i]>bArr[bNumbers[i]]) { //규영이가 해당 레벨에서 이기는 경우
                    kuScore+=aArr[i]+bArr[bNumbers[i]];
                }else if(aArr[i]<bArr[bNumbers[i]]){// 규영이가 해당 레벨에서 지는 경우
                    inScore+=aArr[i]+bArr[bNumbers[i]];
                }
            }
            if(kuScore>inScore){
                totalKuWinCnt+=1;
            }else if(kuScore<inScore){
                totalKuLossCnt+=1;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (bVisited[i]) continue;
            bVisited[i] = true; // 방문 처리
            bNumbers[cnt] = i; // 인덱스 저장
            permutation(cnt + 1);
            bVisited[i] = false;
        }
    }
}
