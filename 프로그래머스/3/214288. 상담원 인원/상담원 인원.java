import java.util.*;
class Solution {
    static List<Job>[] jobsForType;
    public int solution(int K, int N, int[][] reqs) {
        int answer = 0;
        
        jobsForType = new ArrayList[K+1];
        for(int i = 0; i <= K; i++){
            jobsForType[i] = new ArrayList<>();
        }
        
        for(int[] req : reqs) {
            int a = req[0];
            int b = req[1];
            int type = req[2];
            jobsForType[type].add(new Job(a, a + b));
        }
        int[][] waitTimeForEach = new int[K+1][N+1];
        for(int k = 1; k <= K; k++) { // k번째 상담 타입에 
            if(jobsForType[k].size() == 0)continue;
            for(int cnt = 1; cnt <= N - K + 1; cnt++) { // 상담원을 cnt 명 배치했을 때 
                int waitTime = calculate(jobsForType[k], cnt);          
                waitTimeForEach[k][cnt] = waitTime;
            }        
        }
        
        // 상담원들 한명씩 배치
        int[] current = new int[K+1];
        for(int k = 1; k <= K; k++){
            current[k] = 1;
        }
        
        // 한 명씩 배치하고 남은 상담사 수 
        int remain = N - K ; 
        while(remain-- > 0) { // -> 그리디 적인 사고 
            int maxReduceTime = 0; // 상담사 수가 증가했을 떄 대기 시간이 가장 많이 줄어든 시간
            int correspondingType = 0; // 해당 타입의 번호
            for(int type = 1; type <= K; type++){
                int c = current[type];
                int wait = waitTimeForEach[type][c];
                int next = waitTimeForEach[type][c + 1];
                int reduce = Math.abs(wait - next);
                
                if(reduce >= maxReduceTime) {
                    maxReduceTime = reduce;
                    correspondingType = type;
                }
            }
            if(maxReduceTime == 0)break;
            current[correspondingType]++;
        }
        // 상담원 배치가 끝나고 계산
        for(int type = 1; type <= K; type ++){
            if(jobsForType[type].size() == 0)continue;
            int cnt = current[type];
            answer += waitTimeForEach[type][cnt];
        }
        return answer;
    }
    static int calculate(List<Job> jobsForType, int cnt){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int wait = 0;
        for(Job job : jobsForType) {
            if(pq.isEmpty() || pq.size() < cnt){
                pq.add(job.end);
            }else {
                int early = pq.poll();
                if(job.start < early){
                    wait += (early - job.start);
                    pq.add(early + (job.end - job.start));
                }else {
                    pq.add(job.end);
                }
            }
        }
        return wait;
    }
    
    static class Job implements Comparable<Job>{
        int start, end;
        Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Job o){
            return this.end - o.end;
        }
    }
}