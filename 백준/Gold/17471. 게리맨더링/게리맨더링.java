import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 게리맨더링
    static int N;
    static int[] peopleCnt; // 구역 인구 : 1번 구역부터 N번 구역까지 - 인구차이 최소화
    static List<Integer>[] adjList;
    static int allPeople;
    static int minDiffppl = Integer.MAX_VALUE;


    // 서로 다른 N개중 R개 선택
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 구역의 개수

        peopleCnt = new int[N + 1]; // 1번 ~ N번 구역, 인구 공백 구분
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            peopleCnt[n] = Integer.parseInt(st.nextToken());
            allPeople += peopleCnt[n];
        }

        adjList = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            adjList[i] = new ArrayList<>();
        }

        /** 인접 정보 저장 **/
        for (int from = 1; from <= N; from++) { // 1~N번 구역 : 인접한 구역의 정보
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken()); // 인접한 구역의 수
            for (int c = 0; c < cnt; c++) {
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                adjList[to].add(from);
            }
        }

        visited = new boolean[N + 1]; // 1 ~ N
        // 두 선거구의 인구 차이의 최솟값
        // 두 선거구로 나눌 수 없는 경우에는 -1을 출력
        // 인접노드 cnt++
        for (int cnt = 1; cnt <= N / 2; cnt++) {// 선거구 2개로 나눔
            comb(1, cnt);
        }
        if (minDiffppl == Integer.MAX_VALUE) { //
            System.out.println(-1);
        } else {
            System.out.println(minDiffppl);
        }
    }

    private static void comb(int start, int cnt) { // 조합
        if (cnt == 0) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            int cntPpl = 0;
            for (int i = 1; i <= N; i++) {
                if (visited[i]) {// 두 구역구로 나눠진 상태가 저장되어있음. 인접 여부 check
                    groupA.add(i);
                    cntPpl += peopleCnt[i];
                } else {
                    groupB.add(i);
                }
            }

            if(isConnect(groupA.get(0),groupA,groupA.size())&&
            isConnect(groupB.get(0),groupB,groupB.size())){

                // 인접해있다면,
                int pplA = allPeople - cntPpl;
                int pplB = cntPpl;
                minDiffppl = Math.min(minDiffppl, Math.abs(pplA - pplB));

            }
            return;
        }
        for (int i = start; i <= N; i++) {
            visited[i] = true;
            comb(i + 1, cnt - 1);
            visited[i] = false;
        }
    }

    // 선거구가 모두 연결되어있는지 확인.
    public static boolean isConnect(int num, List<Integer> arr, int size) {
        boolean[] visited = new boolean[N + 1];
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i : adjList[start]) {
                // 이미 방문한 적이 없고, arr에 속해야 함.
                if (!visited[i] && arr.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }

        if (count == size) {
            return true;
        }
        return false;
    }

}
